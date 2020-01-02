<template>
  <div class="dashboard-container">
    <div class="dashboard-editor-container">
      <panel-group></panel-group>
      <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
        <line-chart></line-chart>
      </el-row>
    </div>
  </div>
</template>

<script>
  import PanelGroup from './dashboard/PanelGroup'
  import LineChart from './dashboard/LineChart'
  import RadarChart from '@/components/Echarts/RadarChart'
  import PieChart from '@/components/Echarts/PieChart'
  import BarChart from '@/components/Echarts/BarChart'
  import {count} from '@/api/visits'

  /**
   * 记录访问，只有页面刷新或者第一次加载才会记录
   */
  count().then(res => {
  })
  export default {
    name: 'Dashboard',
    components: {
      PanelGroup,
      LineChart,
      RadarChart,
      PieChart,
      BarChart
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .dashboard-editor-container {
    padding: 18px 22px 22px 22px;
    background-color: rgb(240, 242, 245);

    .chart-wrapper {
      background: #fff;
      padding: 16px 16px 0;
      margin-bottom: 32px;
    }
  }
</style>
