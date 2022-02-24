<template>
  <el-card>
    <el-tag>触发Vue的ErrorHandler错误收集</el-tag>
  </el-card>
</template>

<script>
export default {
  name: 'Index',
  created() {
    this.error()
  },
  methods: {
    error() {
      // axios.get()
    }
  }
}
</script>

<style scoped>
</style>
