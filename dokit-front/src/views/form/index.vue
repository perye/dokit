<template>
  <!--  引用https://github.com/JakHuang/form-generator的表单构建，暂时使用iframe引入展示效果，后期更改为Vue组件引入-->
  <elFrame :src="formApi" />
</template>
<script>
import { mapGetters } from 'vuex'
import elFrame from '@/components/Iframe/index'
export default {
  name: 'Form',
  components: { elFrame },
  computed: {
    ...mapGetters([
      'formApi'
    ])
  }
}
</script>
