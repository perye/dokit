<template lang="pug">
  //搜索与重置
  span
    el-button.filter-item(
      size="mini"
      type="success"
      icon="el-icon-search"
      @click="crud.toQuery"
    ) 搜索
    el-button.filter-item(
      size="mini"
      type="warning"
      icon="el-icon-refresh-left"
      @click="crud.resetQuery()"
    ) 重置
</template>
<script>
  import { crud } from '@crud/crud'
export default {
  mixins: [crud()],
  props: {
    itemClass: {
      type: String,
      required: false,
      default: ''
    }
  }
}
</script>
