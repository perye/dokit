<template lang="pug">
  div(v-if="crud.props.searchToggle")
    el-input.filter-item(
      v-model="query.name"
      clearable size="small"
      placeholder="输入岗位名称搜索"
      style="width: 200px;"
      @keyup.enter.native="crud.toQuery"
    )/
    el-date-picker.date-item(
      v-model="query.createTime"
      :default-time="['00:00:00','23:59:59']"
      type="daterange"
      range-separator=":"
      size="small"
      value-format="yyyy-MM-dd HH:mm:ss"
      start-placeholder="开始日期"
      end-placeholder="结束日期"
    )/
    el-select.filter-item(
      v-model="query.enabled"
      clearable
      size="small"
      placeholder="状态"
      style="width: 90px"
      @change="crud.toQuery"
    )
      el-option(
        v-for="item in dict.dict.job_status"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      )/
    rrOperation/
</template>

<script>
import { header } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
export default {
  components: { rrOperation },
  mixins: [header()],
  props: {
    dict: {
      type: Object,
      required: true
    },
    permission: {
      type: Object,
      required: true
    }
  }
}
</script>
