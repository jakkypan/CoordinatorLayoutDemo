# CoordinatorLayoutDemo

## 原理介绍

[pricinple.md](pricinple.md)

## 本Demo效果

### 展示FloatingActionButton和SnackBar的使用

![](./img/1.gif)


### 自定义Behavior，显示和隐藏自己View

这个demo里没有用到系统提供的系统控件作为dependency view，同时实现了child view和dependency view的逻辑，使得dependency view的变化能自动触发child view。

**PS：实际开发中并不需要这么复杂，只是为了展示如何定义Behavior和其原理**

![](./img/2.gif)

### 自定义Behavior，显示和隐藏自己View和actionbar

这里的不同是将自己实现的dependency view换成了AppBarLayout

![](./img/3.gif)

### AppBarLayout的ScrollFlags展示

* **scroll**：View会跟随滚动事件一起发生移动
* **enterAlways**：当ScrollView往下滚动时，该View会直接往下滚动，而不用考虑ScrollView是否在滚动。
* **exitUntilCollapsed**：当这个View要往上逐渐“消逝”时，会一直往上滑动，直到剩下的的高度达到它的最小高度后，再响应ScrollView的内部滑动事件。
* **enterAlwaysCollapsed**：是enterAlways的附加选项，一般跟enterAlways一起使用，它是指，View在往下“出现”的时候，首先是enterAlways效果，当View的高度达到最小高度时，View就暂时不去往下滚动，直到ScrollView滑动到顶部不再滑动时，View再继续往下滑动，直到滑到View的顶部结束。

** PS：enterAlways、exitUntilCollapsed和enterAlwaysCollapsed的使用必须配合scroll**

![](./img/4.gif)

### 
