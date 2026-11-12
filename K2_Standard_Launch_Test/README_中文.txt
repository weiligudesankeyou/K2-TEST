K2 标准 Android 工具链启动测试工程 v2.0
========================================
设备：K2 / QZX_C1 / Hi3798MV300
已知检测：SDK API 19，CPU armeabi-v7a；系统上报的 release 11.0.1 与 API 不一致。

重要提醒：
- 本压缩包是【完整源码工程】，不是 APK，不能直接放电视盒子安装。
- 必须先使用 Android Studio 或 GitHub Actions 正式编译，得到 app-debug.apk。
- 当前发布环境没有安装 Android SDK/Gradle，因此未编译或实机验证；不要把源码 ZIP 改后缀当 APK。
- app-debug.apk 为调试签名测试包，包名 com.k2.launchcheck。
- minSdk 19, targetSdk 22, compileSdk 34, 纯 Java，无任何请求权限，无第三方库。
- 只显示“启动测试成功”及系统参数，遥控器返回键可退出，不修改系统。

方案 A：用 Windows 11 + Android Studio 编译（推荐）
1. 安装并打开官方 Android Studio（建议有条件时联网同步 Gradle）。
2. 解压本 ZIP，用 Android Studio 的 Open 打开解压后的 K2_Standard_Launch_Test 文件夹。
3. 等待 Gradle Sync 成功，需要从 Google Maven 下载 Android Gradle Plugin，安装 Android SDK Platform 34。
4. 菜单 Build -> Build Bundle(s) / APK(s) -> Build APK(s)。
5. 找到文件 app\build\outputs\apk\debug\app-debug.apk。
6. 将 app-debug.apk 传到盒子安装测试。旧版 K2 测试 APK 包名不同，通常不需卸载；若提示签名冲突先卸载旧版。

方案 B：用 GitHub Actions 在线编译（不用在本地装 Android Studio）
1. 创建一个自己的 GitHub 空仓库，把本工程的全部文件与 .github 目录上传到仓库根目录。
2. 进入仓库 Actions -> Build K2 APK -> Run workflow（也会在上传到 main 分支时自动构建）。
3. 等执行成功，在该次运行底部 Artifacts 下载 K2_Standard_Launch_Test_APK.zip。
4. 解压后获得 app-debug.apk，将其传到电视盒子安装。
（GitHub Actions 需要 GitHub 账号及能够访问 GitHub 的网络。）

测试：
能安装且显示 K2 LAUNCH OK：记录 API、ABI、型号并拍照反馈。
能安装但闪退：不要再随意安装其他 APK，改用具备 ADB 的设备抓取崩溃日志。
不能安装：请拍完整报错，记录文件大小及来源。

备注：不是“答题锁电视”正式版，首先解决启动兼容性再开发其他功能。
