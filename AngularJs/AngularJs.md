# AngularJs[^ 1]

### 一、项目结构

![1535362908092](C:\Users\pcq\AppData\Local\Temp\1535362908092.png)

##### 1.src

* 应用代码文件夹。所有的 Angular 组件、模板、样式、图片以及你的应用所需的任何东西都在那里。 这个文件夹之外的文件都是为构建应用提供支持用的。
* src下的文件树目录

![1535363193759](C:\Users\pcq\AppData\Local\Temp\1535363193759.png)

* src目录说明

| 文件                                    | 用途                                                         |
| --------------------------------------- | ------------------------------------------------------------ |
| app/app.component.{ts,html,css,spec.ts} | 使用 HTML 模板、CSS 样式和单元测试定义 `AppComponent` 组件。 它是**根**组件，随着应用的成长它会成为一棵组件树的根节点。 |
| app/app.module.ts                       | 定义 `AppModule`，[根模块](https://www.angular.cn/guide/bootstrapping)为 Angular 描述如何组装应用。 目前，它只声明了 `AppComponent`。 不久，它将声明更多组件。 |
| assets/*                                | 这个文件夹下你可以放图片等任何东西，在构建应用时，它们全都会拷贝到发布包中。 |
| environments/*                          | 这个文件夹中包括为各个目标环境准备的文件，它们导出了一些应用中要用到的配置变量。 这些文件会在构建应用时被替换。 比如你可能在生产环境中使用不同的 API 端点地址，或使用不同的统计 Token 参数。 甚至使用一些模拟服务。 所有这些，CLI 都替你考虑到了。 |
| browserslist                            | 一个配置文件，用来在不同的前端工具之间共享[目标浏览器](https://github.com/browserslist/browserslist)。 |
| favicon.ico                             | 每个网站都希望自己在书签栏中能好看一点。 请把它换成你自己的图标。 |
| index.html                              | 这是别人访问你的网站是看到的主页面的 HTML 文件。 大多数情况下你都不用编辑它。 在构建应用时，CLI 会自动把所有 `js` 和 `css` 文件添加进去，所以你不必在这里手动添加任何 `<script>` 或 `<link>` 标签。 |
| karma.conf.js                           | 给[Karma](https://karma-runner.github.io/)的单元测试配置，当运行 `ng test` 时会用到它。 |
| main.ts                                 | 这是应用的主要入口点。 使用[JIT 编译器](https://www.angular.cn/guide/glossary#jit)编译本应用，并启动应用的根模块 `AppModule`，使其运行在浏览器中。 你还可以使用[AOT 编译器](https://www.angular.cn/guide/glossary#ahead-of-time-aot-compilation)，而不用修改任何代码 —— 只要给 `ng build` 或 `ng serve` 传入 `--aot` 参数就可以了。 |
| polyfills.ts                            | 不同的浏览器对 Web 标准的支持程度也不同。 腻子脚本（polyfill）能把这些不同点进行标准化。 你只要使用 `core-js` 和 `zone.js` 通常就够了，不过你也可以查看[浏览器支持指南](https://www.angular.cn/guide/browser-support)以了解更多信息。 |
| styles.css                              | 这里是你的全局样式。 大多数情况下，你会希望在组件中使用局部样式，以利于维护，不过那些会影响你整个应用的样式你还是需要集中存放在这里。 |
| test.ts                                 | 这是单元测试的主要入口点。 它有一些你不熟悉的自定义配置，不过你并不需要编辑这里的任何东西。 |
| tsconfig.{app\|spec}.json               | TypeScript 编译器的配置文件。`tsconfig.app.json` 是为 Angular 应用准备的，而 `tsconfig.spec.json` 是为单元测试准备的。 |
| tslint.json                             | 额外的 Linting 配置。当运行 `ng lint` 时，它会供带有 [Codelyzer](http://codelyzer.com/) 的 [TSLint](https://palantir.github.io/tslint/) 使用。 Linting 可以帮你们保持代码风格的一致性。 |

##### 2.根目录

| 文件               | 用途                                                         |
| ------------------ | ------------------------------------------------------------ |
| e2e/               | 在 `e2e/` 下是端到端（end-to-end）测试。 它们不在 `src/` 下，是因为端到端测试实际上和应用是相互独立的，它只适用于测试你的应用而已。 这也就是为什么它会拥有自己的 `tsconfig.json`。 |
| node_modules/      | `Node.js` 创建了这个文件夹，并且把 `package.json` 中列举的所有第三方模块都放在其中。 |
| .editorconfig      | 给你的编辑器看的一个简单配置文件，它用来确保参与你项目的每个人都具有基本的编辑器配置。 大多数的编辑器都支持 `.editorconfig` 文件，详情参见 [http://editorconfig.org](http://editorconfig.org/) 。 |
| .gitignore         | 一个 Git 的配置文件，用来确保某些自动生成的文件不会被提交到源码控制系统中。 |
| angular.json       | Angular CLI 的配置文件。 在这个文件中，你可以设置一系列默认值，还可以配置项目编译时要包含的那些文件。 要了解更多，请参阅它的官方文档。 |
| package.json       | `npm` 配置文件，其中列出了项目使用到的第三方依赖包。 你还可以在这里添加自己的[自定义脚本](https://docs.npmjs.com/misc/scripts)。 |
| protractor.conf.js | 给[Protractor](http://www.protractortest.org/)使用的端到端测试配置文件，当运行 `ng e2e` 的时候会用到它。 |
| README.md          | 项目的基础文档，预先写入了 CLI 命令的信息。 别忘了用项目文档改进它，以便每个查看此仓库的人都能据此构建出你的应用。 |
| tsconfig.json      | TypeScript 编译器的配置，你的 IDE 会借助它来给你提供更好的帮助。 |
| tslint.json        | 给[TSLint](https://palantir.github.io/tslint/)和[Codelyzer](http://codelyzer.com/)用的配置信息，当运行 `ng lint` 时会用到。 Lint 功能可以帮你保持代码风格的统一。 |

### 







---

[^ 1]: 官方中文学习文档地址:https://www.angular.cn 