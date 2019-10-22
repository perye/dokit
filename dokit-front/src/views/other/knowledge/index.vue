<template>
  <div class="knowledge-container">
    <p class="warn-content">
      基于<a  href="https://github.com/ownthink/KnowledgeGraphData" target="_blank">史上最大规模1.4亿中文知识图谱API</a></p>
    <el-form ref="form" :model="form" label-width="80">
      <el-form-item label="知识搜索">
        <el-input v-model="form.text" placeholder="人工智能"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <div class="answer">{{form.answer}}</div>
  </div>
</template>

<script>
    import { searchKnowledge } from '@/api/other'
    export default {
        name: "index",
        data() {
            return {
                form:{
                    text: "",
                    answer: "请输入文本查询"
                }
            };
        },
        methods:{
            onSubmit() {
                searchKnowledge(this.form.text).then(result => {
                    this.form.answer = result.data.info.text;
                });
            }
        }

    }
</script>

<style scoped>
.knowledge-container{
  margin: 10px 20px 0;
  overflow: hidden;
}
.answer{
  padding: 15px;
  line-height: 20px;
  border-left: 3px solid #ddd;
  color: #333;
  font-family: Courier New;
  font-size: 12px
}
</style>
