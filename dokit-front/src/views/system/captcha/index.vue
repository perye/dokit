<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <!--表单组件-->
      <el-dialog
        :append-to-body="true"
        :close-on-click-modal="false"
        :before-close="cancel"
        :visible.sync="dialog"
        :title="getFormTitle()"
        width="500px"
      >
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="验证码类型" prop="type">
            <el-radio v-for="item in dict.captcha_type" :key="item.id" v-model="form.type" :label="item.value">{{
              item.label }}
            </el-radio>
          </el-form-item>
          <el-form-item label="字体名字">
            <el-radio v-for="item in dict.font_name" :key="item.id" v-model="form.fontName" :label="item.value">{{
              item.label }}
            </el-radio>
          </el-form-item>
          <el-form-item label="字体风格">
            <el-radio
              v-for="item in dict.captcha_fontstyle"
              :key="item.id"
              v-model="form.fontStyle"
              :label="item.value"
            >{{ item.label }}
            </el-radio>
          </el-form-item>
          <el-form-item label="字体大小">
            <el-input v-model="form.fontSize" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="宽度">
            <el-input v-model="form.width" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="高度">
            <el-input v-model="form.height" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="位数">
            <el-input v-model="form.len" style="width: 370px;" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="cancel">取消</el-button>
          <el-button :loading="loading" type="primary" @click="submitMethod">确认</el-button>
        </div>
      </el-dialog>
      <!--表格渲染-->
      <el-table ref="table" v-loading="loading" :data="data" size="small" style="width: 100%;">
        <el-table-column prop="type" label="验证码类型">
          <template slot-scope="scope">
            {{ dict.label.captcha_type[scope.row.type] }}
          </template>
        </el-table-column>
        <el-table-column prop="fontName" label="字体名字">
          <template slot-scope="scope">
            {{ dict.label.font_name[scope.row.fontName] }}
          </template>
        </el-table-column>
        <el-table-column prop="fontStyle" label="字体风格">
          <template slot-scope="scope">
            {{ dict.label.captcha_fontstyle[scope.row.fontStyle] }}
          </template>
        </el-table-column>
        <el-table-column prop="fontSize" label="字体大小" />
        <el-table-column prop="width" label="宽度" />
        <el-table-column prop="height" label="高度" />
        <el-table-column prop="len" label="位数" />
        <el-table-column
          v-if="checkPermission(['admin','captcha:edit'])"
          label="操作"
          width="150px"
          align="center"
        >
          <template slot-scope="scope">
            <el-button
              v-permission="['admin','captcha:edit']"
              size="mini"
              type="primary"
              icon="el-icon-edit"
              @click="showEditFormDialog(scope.row)"
            />
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import crud from '@/mixins/crud'
import crudCaptcha from '@/api/captcha'

export default {
  mixins: [crud],
  dicts: ['captcha_type', 'font_name', 'captcha_fontstyle'],
  data() {
    return {
      title: 'captcha',
      crudMethod: { ...crudCaptcha },
      form: {
        id: null,
        type: null,
        fontName: null,
        fontStyle: null,
        fontSize: null,
        width: null,
        height: null,
        len: null
      },
      rules: {
        id: [
          { required: true, message: 'id不能为空', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '验证码类型不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.$nextTick(() => {
      this.init()
    })
  },
  methods: {
    // 获取数据前设置好接口地址
    beforeInit() {
      this.url = 'api/captcha'
      const sort = 'id,desc'
      this.params = { page: this.page, size: this.size, sort: sort }
      return true
    }
  }
}
</script>
<style scoped>
</style>
