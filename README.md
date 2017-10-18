# PraiseWidget
// 这个是点赞控件哦，适用于社交类app</br>
### 实际效果可以看看我在[朋友圈项目](https://github.com/razerdp/FriendCircle)的使用

实现流程：http://blog.csdn.net/mkfrank/article/details/49963779
</br>
## 效果图：</br>
![image](https://github.com/razerdp/PraiseWidget/blob/master/img/praise widget.gif)
## 使用方法：</br>
在xml定义控件，findViewById后，使用setDataByArray传入数据（本例子用的是PraiseBean），您可以改成你需要用的</br>
正因为如此，我并没有抽取为一个Library</br>
如果需要跟显示图一样超过5行就显示“等xx人”，**请跟TextView一样给定android:maxLines="5"**
</br>
## 可定义的属性：(attrs.xml)</br>
```html
     <!--显示点赞控件-->
      <declare-styleable name="PraiseWidget">
          <attr name="click_bg_color" format="color"/> //点击的背景色，默认全透明
          <attr name="font_color" format="color"/>  //文字颜色，默认蓝
          <attr name="font_size" format="dimension"/>  //文字大小，默认16sp
          <attr name="zan_icon" format="reference"/>  //第一个点赞的图标，默认一个蓝色的心心
      </declare-styleable>
```
## 注意事项：</br>
因为使用了缓存，所以如果在activity引用了，请务必在onDestroy里面调用PraiseWidget.clearPraiseWidgetCache清掉context引用，避免无法回收
