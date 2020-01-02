# dokit

Just do kit!

#### 项目简介
基于 Spring Boot 2.1.9 、 Jpa、 Spring Security、redis、Vue的前后端分离的后台管理系统， 权限控制的方式为RBAC，项目支持数据字典与数据权限管理，支持一键生成前后端代码（支持在线预览及打包下载），支持前端菜单动态路由
可一键部署服务器应用，数据库。系统中活跃用户状态监控，监视当前系统CPU、内存、磁盘、堆栈等相关信息。

- 前后端统一异常拦截处理，统一输出异常，避免繁琐的判断
- 高效率开发，使用代码生成器可以一键生成前后端代码
- 支持数据字典，可方便的对一些状态进行管理
- 支持接口限流，避免恶意请求导致服务层压力过大
- 支持接口级别的功能权限与数据权限，可自定义操作
- 自定义权限注解与匿名接口注解，可快速对某一接口拦截与放行
- 对一些常用的前端组件封装：表格数据请求、数据字典等

##### 后端技术

| 技术                 | 说明                | 
| -------------------- | ------------------- |
| SpringBoot           | 容器+MVC框架        | 
| SpringSecurity       | 认证和授权框架      | 
| Spring-data-jpa      | ORM框架             | 
| Spring Cache         | Spring缓存
| Swagger-UI           | 文档生产工具        | 
| log4jdbc             | 监控sql日志            |
| Redis                | 分布式缓存          | 
| Druid                | 数据库连接池        | 
| OSS                  | 对象存储            | 
| JWT                  | JWT登录支持         | 
| Lombok               | 简化对象封装工具    | 
| quartz               | 作业调度框架          |
| freemarker           | 模版引擎             |
| sigar                | 系统信息              |
| websocket            | TCP通信          |
| ssh2                 | 服务器连接          |
| jsch                 | SFTP文件传输       |
| mapstruct            | 属性映射工具         |
| ip2region            | 根据ip转换成具体地理位置 |
| mysql| 关系型数据库|

##### 前端技术

| 技术       | 说明                  | 
| ---------- | --------------------- 
| Vue        | 前端框架              | 
| Vue-router | 路由框架              | 
| Vuex       | 全局状态管理框架      | 
| Element    | 前端UI框架            | 
| Axios      | 前端HTTP框架          | 
| echarts   | 基于Echarts的图表框架 | 
| Js-cookie  | cookie管理工具        | 
| nprogress  | 进度条控件            | 
| vue-count-to|数字滚动 |
| vue-highlightjs|代码语法高亮|
| qs            | 对象序列化        |
| vue-cropper | 图片剪切|
| vue-splitpane | 前端页面分割|
| path-to-regexp| url正则表达 |
| wangeditor|富文本编辑器 |
| mavon-editor|markdown编辑器|
| jszip|    压缩解压|
| jsencrypt | 参数前端加密|
| fusejs|基于 JavaScript 的轻量级模糊搜索引擎 |
| file-saver|客户端保存文件|
| codemirror|在线编辑代码|
| clipboard| 点击复制|
| vue-treeselect| 树形选择器|
| vue-jsx|JSX语法|
| screenfullJS| 全屏|
| xlsx| 生成报表 |
| sass| CSS扩展语言|
| svgo| svg压缩|

####  系统功能
- 用户管理：提供用户的相关配置，新增用户后，默认密码为123456
- 角色管理：对权限与菜单进行分配，可根据部门设置角色的数据权限
- 菜单管理：菜单动态路由，后端可配置化，支持多级菜单
- 部门管理：可配置系统组织架构，树形表格展示
- 岗位管理：配置各个部门的职位
- 字典管理：可维护常用一些固定的数据，如：状态，性别等
- 操作日志：记录用户操作的日志
- 异常日志：记录异常日志，方便开发人员定位错误，异常信息前台高亮显示
- 系统缓存：使用jedis将缓存操作可视化，并提供对redis的基本操作，可根据需求自行扩展
- SQL监控：采用druid 监控数据库访问性能，默认用户名admin，密码123456
- 定时任务：整合Quartz做定时任务，加入任务日志，任务运行情况一目了然
- 代码生成：高灵活度一键生成前后端代码，减少百分之80左右的工作任务，可以预览生成结果
- 邮件工具：配合富文本，发送html格式的邮件
- 系统接口：根据业务代码自动生成相关的api接口文档。
- 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
- 图床管理：使用sm.ms图床，用作公共图片上传使用
- 七牛云存储：可同步七牛云存储的数据到系统，无需登录七牛云直接操作云数据
- 支付宝支付：整合了支付宝支付并且提供了测试账号，可自行测试
- 在线用户：当前系统中活跃用户状态监控，查看实时在线用户，可以管理在线用户，踢下线等操作
- 服务器： 可以连接云服务器进行管理
- 数据库管理： 连接数据方便更新数据库脚本
- 应用管理：上传jar包到服务器进行管理
- 部署管理：可一键部署，根据配置的服务器和应用程序，线上直接配置，无需命令行

#### 项目结构
```
后端
.
├── main
│   ├── java
│   │   └── com
│   │       └── perye
│   │           └── dokit
│   │               ├── DokitApplication.java       应用启动类
│   │               ├── annotation                  系统自定义注解
│   │               ├── aop                     
│   │               ├── aspect                      自定义注解的切面
│   │               ├── base                        提供了Entity、DTO基类和mapstruct的通用mapper
│   │               ├── config                      自定义权限实现、redis配置、swagger配置
│   │               ├── controller
│   │               ├── dto
│   │               ├── entity
│   │               ├── exception                   统一异常的处理
│   │               ├── mapper
│   │               ├── redis
│   │               ├── repository
│   │               ├── security
│   │               ├── service
│   │               ├── swagger2
│   │               ├── task
│   │               ├── utils                       系统通用工具类
│   │               ├── vo
│   │               └── websocket
│   └── resources
│       ├── banner.txt
│       ├── config
│       │   ├── application-dev.yml
│       │   ├── application-prod.yml
│       │   └── application.yml
│       ├── generator.properties
│       ├── ip2region               ip转换
│       │   └── ip2region.db
│       ├── log4jdbc.log4j2.properties
│       ├── logback.xml
│       ├── sigar-lib               sigar所需文件
│       ├── sql
│       │   └── dokit.sql           sql文件
│       └── template
│           ├── email
│           │   └── email.ftl       发送邮件模版
│           └── generator           自动生成代码模版    
│               ├── admin       
│               │   ├── Controller.ftl
│               │   ├── Dto.ftl
│               │   ├── Entity.ftl
│               │   ├── Mapper.ftl
│               │   ├── QueryCriteria.ftl
│               │   ├── Repository.ftl
│               │   ├── Service.ftl
│               │   └── ServiceImpl.ftl
│               └── front
│                   ├── api.ftl
│                   └── index.ftl
└──
```

```
前端
.
├── LICENSE
├── README.md
├── babel.config.js
├── jest.config.js
├── package.json
├── plopfile.js
├── postcss.config.js
├── public
│   ├── favicon.ico
│   └── index.html
├── src
│   ├── App.vue
│   ├── api
│   ├── assets
│   ├── components
│   │   ├── Breadcrumb
│   │   ├── Crud
│   │   ├── Dict
│   │   ├── Echarts
│   │   ├── Hamburger
│   │   ├── HeaderSearch
│   │   ├── IconSelect
│   │   ├── Iframe
│   │   ├── JavaEdit
│   │   ├── Pagination
│   │   ├── PanThumb
│   │   ├── Permission
│   │   ├── RightPanel
│   │   ├── Screenfull
│   │   ├── SizeSelect
│   │   ├── SvgIcon
│   │   ├── ThemePicker
│   │   └── YamlEdit
│   ├── layout
│   ├── main.js
│   ├── mixins
│   ├── router
│   ├── settings.js
│   ├── store
│   ├── utils
│   └── views
│       ├── components
│       ├── dashboard
│       ├── features
│       ├── generator
│       ├── home.vue
│       ├── login.vue
│       ├── mnt
│       ├── monitor
│       ├── system
│       └── tools
├── static
├── tree.txt
├── vue.config.js
└── yarn.lock

```

#### 项目截图

首页
![首页](./asserts/dashboard.png)

用户管理
![用户管理](./asserts/user.png)

角色管理及菜单分配
![角色管理](./asserts/role.png)

菜单管理
![菜单管理](./asserts/menu.png)

部门管理
![部门管理](./asserts/dept.png)

岗位管理
![岗位管理](./asserts/jobs.png)

字典管理
![字典管理](./asserts/dict.png)

在线用户
![在线用户](./asserts/online.png)

操作日志
![操作日志](./asserts/logs.png)

错误日志
![错误日志](./asserts/errorLog.png)

错误日志详情
![错误日志详情](./asserts/errorDetail.png)

服务监控
![服务监控](./asserts/server.png)

系统缓存
![系统缓存](./asserts/redis.png)

sql监控
![sql监控](./asserts/druid.png)

服务器
![服务器](./asserts/serverDeploy.png)

应用管理
![应用管理](./asserts/app.png)

部署管理
![部署管理](./asserts/deploy.png)

部署备份
![部署备份](./asserts/deployHistory.png)

数据库管理
![数据库管理](./asserts/database.png)

定时任务
![定时任务](./asserts/timing.png)

代码生成
![代码生成](./asserts/generator.png)

图床管理
![图床管理](./asserts/pictures.png)

接口文档
![接口文档](./asserts/swagger.png)

图表库
![图表库](./asserts/echarts.png)

图标库
![图标库](./asserts/icon.png)

富文本
![富文本](./asserts/tinymce.png)

MarkDown
![MarkDown](./asserts/markdown.png)

Yaml编辑
![Yaml编辑器](./asserts/yaml.png)
