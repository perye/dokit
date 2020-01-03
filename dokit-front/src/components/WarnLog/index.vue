<template>
  <div v-if="warnLogs.length>0">
    <el-badge :is-dot="true" style="line-height: 25px;margin-top: -5px;" @click.native="dialogTableVisible=true">
      <el-button style="padding: 8px 10px;" size="small" type="warning">
        <svg-icon icon-class="bug" />
      </el-button>
    </el-badge>

    <el-dialog :visible.sync="dialogTableVisible" width="80%" append-to-body>
      <div slot="title">
        <span style="padding-right: 10px;">警告日志收集</span>
        <el-button size="mini" type="primary" icon="el-icon-delete" @click="clearAll">Clear All</el-button>
      </div>
      <el-table :data="warnLogs" border>
        <el-table-column label="Message">
          <template slot-scope="{row}">
            <div>
              <span class="message-title">Msg:</span>
              <el-tag type="danger">
                {{ row.msg }}
              </el-tag>
            </div>
            <br>
            <div>
              <span class="message-title" style="padding-right: 10px;">Info: </span>
              <el-tag type="warning">
                {{ row.vm.$vnode.tag }}
              </el-tag>
            </div>
            <br>
            <div>
              <span class="message-title" style="padding-right: 16px;">Url: </span>
              <el-tag type="success">
                {{ row.url }}
              </el-tag>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="Stack">
          <template slot-scope="scope">
            {{ scope.row.trace }}
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'WarnLog',
  data() {
    return {
      dialogTableVisible: false
    }
  },
  computed: {
    warnLogs() {
      return this.$store.getters.warnLogs
    }

  },
  methods: {
    clearAll() {
      this.dialogTableVisible = false
      this.$store.dispatch('errorLog/clearWarnLog')
    }
  }
}
</script>

<style scoped>
  .message-title {
    font-size: 16px;
    color: #333;
    font-weight: bold;
    padding-right: 8px;
  }
</style>
