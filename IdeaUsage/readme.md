### IDEA常用快捷键与重构技巧

1. 复制文件：F5

2. 移动文件：F6

3. 窗口移动或切换：

    - ​		移动窗口，但光标位置不移动 ctrl + ↑或↓
    - ​		切换已经IDEA打开的窗口：ctrl + alt + [或者]

4. 移动代码：ctrl + shift + ↑或↓

    - ​		行级移动，选中多行代码

    - ​		方法移动，光标在方法名所在行

5. 定位代码：

    - ​		返回上次代码编辑的位置 ctrl + shift + backspace

    - ​		返回上次光标所在的位置 ctrl + alt + 左右方向键

    - ​		返回光标所在词的开始位置/末尾位置 ctrl + 左右方向键
    
    - ​		返回下一个方法所在位置 alt + ↑或↓
    
    - ​		下一个错误或警告 F2

    - ​		返回光标所对应的括号 ctrl + shift + M

    - ​		返回光标所对应的大括号 ctrl + [或者]

6. 选中代码：

    - ​		选中光标左右一个词的代码 ctrl + shift + 左右方向键
    
    - ​		选中光标上下行的代码 shift + ↑或↓
    
    - ​		选中光标所在位置对应词的所有代码 ctrl + shift + alt + J

7. 提取代码：

    - ​		提取变量值为新变量 ctrl + alt + v
    
    - ​		提取变量值为常量 ctrl + alt + c
    
    - ​		提取变量为属性 ctrl + alt + f
    
    - ​		提取代码（可以是变量值，也可以是代码块）成方法 ctrl + alt + m——将方法的实现代码复制到调用处并删除方法 ctrl + alt + n
    
    - ​		提取方法内的变量为方法的参数 ctrl + alt + p
    
    - ​		提取方法的参数为新的类对象
    
    - ​		提取代码到父类  Refactor -> Pull Members Up
    
    - ​		提取代码到子类  Refactor -> Push Members Down
    
    - ​		提取代码并创建委托类  Refactor -> Extract -> Delegate
    
    - ​		提取代码并创建接口  Refactor -> Extract -> Interface
    
    - ​		提取代码并创建父类  Refactor -> Extract -> Superclass
    
    - ​		重新封装方法返回值对象。执行 Refactor -> Wrap Return Value

    - ​		使用工厂模式代替构造方法 Refactor -> Replace Constructor With Factory Method
    
    - ​		使用建造者代模式替构造方法  Refactor -> Replace Constructor With Builder

8. 修改名字：shift + F6

    - ​		修改文件名，选中文件
    
    - ​		修改类名，选中类名
    
    - ​		修改方法名，选中方法名

9. 修改方法结构：ctrl + F6

    - ​		修改方法名
    
    - ​		修改参数名
    
    - ​		修改参数类型
    
    - ​		修改返回值类型

10. 修改方法返回值对象：重新封装方法返回值对象。执行 Refactor -> Wrap Return Value
    
    - ​		修改返回类型
    
    - ​		修改并创建新的返回类型

11. 辅助查看代码：
    
    - ​		设置或取消书签：F11
    
    - ​		设置或取消书签（带标记）：ctrl + F11
    
    - ​		查看书签：shift + F11
    
    - ​		光标定位到工程目录：F12
    
    - ​		查看当前文件的结构： ctrl + F12
    
    - ​		最大化编辑窗口：ctrl + shift + F12
    
    - ​		在文件浏览器中打开文件或文件夹：ctrl + alt + F12
    
    - ​		收起/展开光标所在代码块的代码：ctrl + -/+
    
    - ​		收起/展开当前文件的所有代码：ctrl + shift + -/+
    
    - ​		逐级收起/展开当前文件的所有代码：ctrl + alt + -/+

    - ​		在弹框中显示代码：ctrl + shift + I

    - ​		Diagram for 当前文件：ctrl + alt + U

    - ​		查看当前方法的定义：ctrl + U

    - ​		查看当前方法的实现：ctrl + alt + B
    
12. 其他快捷键
    
    - ​		字母大写/小写：ctrl + shift + U
    
    - ​		移除不使用的包：ctrl + alt + O
    
    - ​		格式化代码：ctrl + alt + L
    
    - ​		再次格式化代码：ctrl + shift + alt + L

    - ​		创建测试类：ctrl + shift + T

    - ​		Surround With：ctrl + alt + T

