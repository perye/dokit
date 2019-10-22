<template>
  <div class="knowledge-container">
    <p class="warn-content">
      基于<a  href="https://github.com/ownthink/KnowledgeGraphData" target="_blank">史上最大规模1.4亿中文知识图谱API</a></p>
    <el-form ref="form" :model="form" label-width="80">
      <el-form-item label="知识搜索"><br>
        <div class="tag-group" v-if="form.hot.length>0">
          <span class="tag-group__title">热门查询</span>
          <el-tag
            v-for="item in form.hot"
            :key="item"
            type="danger"
            style="margin-left: 5px"
            effect="plain"
            @click="tagSearch(item)">
            {{ item }}
          </el-tag>
        </div>
        <div class="tag-group" v-if="form.hot.length>0">
          <span class="tag-group__title">最新查询</span>
          <el-tag
            v-for="item in form.new"
            :key="item"
            type="success"
            style="margin-left: 5px"
            effect="plain"
            @click="tagSearch(item)">
            {{ item }}
          </el-tag>
        </div>
        <el-input v-model="form.text" placeholder="人工智能"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" :loading="submitStatus" :disabled="submitStatus" @click="onSubmit">{{submitText}}</el-button>
      </el-form-item>

    </el-form>
    <div class="answer">{{form.answer}}</div>
  </div>
</template>

<script>
    import { searchKnowledge,hotSearch,newSearch } from '@/api/other'
    export default {
        name: "index",
        data() {
            return {
                form:{
                    text: "",
                    answer: "请输入文本查询",
                    hot: {text:""},
                    new: {text:""}
                },
                submitStatus:false,
                submitText: "查询"
            };
        },
        created() {
            this.initSearch();
        },
        mounted(){
            this.$nextTick(function () {
                //10分钟刷新一次榜单,防止长时间不更新
                setInterval(this.initSearch, 1000*60*10);
            })
        },
        methods:{
            onSubmit() {
                this.submitStatus = true;
                this.submitText = "查询中";
                if (this.form.text === "") {
                    this.$message.error("搜索不能为空");
                } else {
                    searchKnowledge(this.form.text).then(result => {
                        console.log(result.data)
                        this.form.answer = result.data.info.text;
                        this.initSearch()
                        this.submitStatus = false;
                        this.submitText = "查询";
                    });
                }

            },
            initSearch(){
                hotSearch().then(result => {
                    this.form.hot = result;
                });
                newSearch().then(result => {
                    this.form.new = result;
                });
            },
            tagSearch(item) {
                this.form.text = item;
                this.onSubmit();
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
