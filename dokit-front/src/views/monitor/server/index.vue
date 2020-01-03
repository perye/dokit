<template>
  <div>
    <div>
      <el-divider content-position="left">CPU</el-divider>
      <el-row class="panel-group" :gutter="40">
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-people">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">核心数</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="cpu.cpuNum" :duration="2600" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-money">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">CPU系统使用率</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="cpu.sys" :decimals="2" :suffix="'%'" :duration="3200" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">CPU用户使用率</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="cpu.used" :decimals="2" :suffix="'%'" :duration="3600" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">CPU当前空闲率</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="cpu.free" :decimals="2" :suffix="'%'" :duration="3600" />
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

    <div>
      <el-divider content-position="left">內存</el-divider>
      <el-row class="panel-group" :gutter="40">
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-people">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">内存总量</div>
              <count-to class="card-panel-num" :decimals="2" :suffix="'G'" :start-val="0" :end-val="mem.total" :duration="2600" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-message">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">已用内存</div>
              <count-to class="card-panel-num" :decimals="2" :suffix="'G'" :start-val="0" :end-val="mem.used" :duration="3000" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-money">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">剩余内存</div>
              <count-to class="card-panel-num" :decimals="2" :start-val="0" :end-val="mem.free" :suffix="'G'" :duration="3200" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="6">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">内存使用率</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="mem.usage" :decimals="2" :suffix="'%'" :duration="3600" />
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

    <div>
      <el-divider content-position="left">Java虚拟机信息</el-divider>
      <el-row class="panel-group" :gutter="40">
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-people">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JDK名称</div>
              <span>{{ jvm.name }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-message">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JDK版本</div>
              <span>{{ jvm.version }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-money">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JDK路径</div>
              <el-tooltip class="item" effect="dark" :content="jvm.home" placement="top">
                <span>{{ jvm.home | ellipsis }}</span>
              </el-tooltip>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">当前JVM占用的内存总数</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="jvm.total" :decimals="2" :suffix="'M'" :duration="3600" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JVM最大可用内存总数</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="jvm.max" :decimals="2" :suffix="'M'" :duration="3600" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JVM空闲内存</div>
              <count-to class="card-panel-num" :start-val="0" :end-val="jvm.free" :decimals="2" :suffix="'M'" :duration="3600" />
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JDK启动时间</div>
              <span>{{ jvm.startTime }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">JDK运行时间</div>
              <span>{{ jvm.runTime }}</span>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

    <div>
      <el-divider content-position="left">系统相关信息</el-divider>
      <el-row class="panel-group" :gutter="40">
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-people">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">服务器名称</div>
              <span>{{ sys.computerName }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-message">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">服务器Ip</div>
              <span>{{ sys.computerIp }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-money">
              <svg-icon icon-class="visits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">项目路径</div>
              <span>{{ sys.userDir }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">操作系统</div>
              <span>{{ sys.osName }}</span>
            </div>
          </div>
        </el-col>
        <el-col class="card-panel-col" :xs="12" :sm="12" :lg="8">
          <div class="card-panel">
            <div class="card-panel-icon-wrapper icon-shopping">
              <svg-icon icon-class="ipvisits" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">系统架构</div>
              <span>{{ sys.osArch }}</span>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import CountTo from 'vue-count-to'
import { get } from '@/api/server'

export default {
  name: 'Index',
  components: {
    CountTo
  },
  filters: {
    ellipsis(value) {
      if (!value) return ''
      if (value.length > 40) {
        return value.slice(0, 40) + '...'
      }
      return value
    }
  },
  data() {
    return {
      cpu: { cpuNum: 0, sys: 0, used: 0, free: 0 },
      mem: { total: 0, used: 0, free: 0, usage: 0 },
      jvm: { name: '', home: '', version: '', startTime: '', runTime: '', total: 0, max: 0, free: 0, used: 0, usage: 0 },
      sys: { computerName: '', computerIp: '', userDir: '', osName: '', osArch: '' }
    }
  },
  mounted() {
    get().then(res => {
      console.log(res)
      this.cpu.cpuNum = res.cpu.cpuNum
      this.cpu.sys = res.cpu.sys
      this.cpu.used = res.cpu.used
      this.cpu.free = res.cpu.free

      this.mem.total = res.mem.total
      this.mem.used = res.mem.used
      this.mem.free = res.mem.free
      this.mem.usage = res.mem.usage

      this.jvm.name = res.jvm.name
      this.jvm.home = res.jvm.home
      this.jvm.version = res.jvm.version
      this.jvm.startTime = res.jvm.startTime
      this.jvm.runTime = res.jvm.runTime
      this.jvm.total = res.jvm.total
      this.jvm.max = res.jvm.max
      this.jvm.free = res.jvm.free
      this.jvm.used = res.jvm.used
      this.jvm.usage = res.jvm.usage

      this.sys.computerName = res.sys.computerName
      this.sys.computerIp = res.sys.computerIp
      this.sys.userDir = res.sys.userDir
      this.sys.osName = res.sys.osName
      this.sys.osArch = res.sys.osArch
    })
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .panel-group {
    margin-top: 18px;

    .card-panel-col {
      margin-bottom: 32px;
    }

    .card-panel {
      height: 108px;
      font-size: 12px;
      position: relative;
      overflow: hidden;
      color: #666;
      background: #fff;
      box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
      border-color: rgba(0, 0, 0, .05);

      .icon-people {
        color: #40c9c6;
      }

      .icon-message {
        color: #36a3f7;
      }

      .icon-money {
        color: #f4516c;
      }

      .icon-shopping {
        color: #34bfa3
      }

      .card-panel-icon-wrapper {
        float: left;
        margin: 14px 0 0 14px;
        padding: 16px;
        transition: all 0.38s ease-out;
        border-radius: 6px;
      }

      .card-panel-icon {
        float: left;
        font-size: 48px;
      }

      .card-panel-description {
        float: right;
        font-weight: bold;
        margin: 26px;
        margin-left: 0px;

        .card-panel-text {
          line-height: 18px;
          color: rgba(0, 0, 0, 0.45);
          font-size: 16px;
          margin-bottom: 12px;
        }

        .card-panel-num {
          font-size: 20px;
        }
      }
    }
  }
</style>

