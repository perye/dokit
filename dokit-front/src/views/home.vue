<template>
  <div class="dashboard-container">
    <div class="dashboard-editor-container">
      <github class="github-corner" />
      <panel-group />
      <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
        <line-chart />
      </el-row>
    </div>
  </div>
</template>

<script>
import Github from '@/components/Github'
import PanelGroup from './dashboard/PanelGroup'
import LineChart from './dashboard/LineChart'
import { count } from '@/api/visits'

/**
   * 记录访问，只有页面刷新或者第一次加载才会记录
   */
count().then(res => {
})
export default {
  name: 'Dashboard',
  components: {
    Github,
    PanelGroup,
    LineChart
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .dashboard-editor-container {
    padding: 32px;
    background-color: rgb(240, 242, 245);
    position: relative;

    .github-corner {
      position: absolute;
      top: 0px;
      border: 0;
      right: 0;
    }

    .chart-wrapper {
      background: #fff;
      padding: 16px 16px 0;
      margin-bottom: 32px;
    }
  }

  @media (max-width:1024px) {
    .chart-wrapper {
      padding: 8px;
    }
  }
</style>
