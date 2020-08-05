# Flex Style

## 一、Flex Style与CSS

### 1.使用外部样式表文件

* css样式表内容

```css

@namespace s "library://ns.adobe.com/flex/spark";
@namespace mx "library://ns.adobe.com/flex/mx";

.heading
{
	fontFamily: Arial, Helvetica, sans-serif;
	fontSize: 17px;
	color: #9b1204;
	textDecoration:none;
	fontWeight:normal;
}

.button {
	fontWeight: bold;			
}

.container {
	cornerRadius :10;
	horizontalCenter :0;	
	borderColor: #777777;
	verticalCenter:0;
	backgroundColor: #efefef;
}
```

* mxml文件中引入外部样式表并且组件使用

```xml
<!--引入外部样式表-->
<fx:Style source="/classpath/Style.css"/>

<!--UI组件使用样式表中的某个样式通过styleName属性指定-->
<s:BorderContainer width="500" height="500" id="mainContainer" 
      styleName="container"> 
</s:BorderContainer>
```



### 2.在UI容器组件中使用样式

#### 2.1 类级别选择器

```xml
<fx:Style>
@namespace s "library://ns.adobe.com/flex/spark";
@namespace mx "library://ns.adobe.com/flex/mx";

/* class level selector  */
.errorLabel {
   color: red;
}		
</fx:Style>
<!-- UI组件使用 -->
<s:Label id="errorMsg" text="This is an error message" styleName="errorLabel"/>
```

#### 2.2 id级别选择器

```xml
<fx:Style>
/* id level selector  */
#msgLabel {
   color: gray;
}
</fx:Style>

<s:Label id="msgLabel" text="This is a normal message" />
```

#### 2.3 类型级别选择器

```xml
<!--给某种特定组件元素配置style,这里是s|Button元素组件-->
<fx:Style>
/* style applied on all buttons  */
s|Button { 
   fontSize: 15;
   color: #9933FF;
}
</fx:Style>

<s:Button label="Click Me!" id="btnClickMe" 
click="btnClickMe_clickHandler(event)"  />
```

## 二、Flex Style与Skin

### 1.什么是Skinning？

- Flex中的Skinning是一个完全自定义UI组件的外观和感觉的过程。
- 皮肤可以定义组件的文本，图像，过滤器，过渡和状态。
- 可以将皮肤创建为单独的mxml和ActionScript组件。
- 使用皮肤，我们可以控制UI组件的所有视觉方面。
- 定义皮肤的过程对于所有UI组件是相同的。

### 2.如何使用皮肤

#### 2.1 创建皮肤

![fb创建skin](.\img\创建skin.png)

图中配置了包，以及该skin的名称，应用的主机组件为**spark.components.BorderContainer**

创建好的backgroundskin.mxml内容如下所示：

```xml
<?xml version="1.0" encoding="utf-8"?>
<s:Skin xmlns:fx="http://ns.adobe.com/mxml/2009" 
		xmlns:s="library://ns.adobe.com/flex/spark" 
		xmlns:mx="library://ns.adobe.com/flex/mx">
	<!-- host component -->
	<fx:Metadata>
		[HostComponent("spark.components.BorderContainer")]
	</fx:Metadata>
	
	<!-- states -->
	<s:states>
		<s:State name="disabled" />
		<s:State name="normal" />
	</s:states>
	
	<!-- SkinParts
	name=contentGroup, type=spark.components.Group, required=false
	-->
</s:Skin>
```

#### 2.2 涂抹皮肤

##### （1）在mxml中静态应用皮肤

```xml
<!--通过skinClass属性给UI组件设置皮肤-->
<s:BorderContainer width="1000" height="500" id="mainContainer" 
					   styleName="container"  skinClass="spark.skins.spark.BorderContainerSkin">
```

##### （2）在actionscript中动态应用皮肤

```javascript
protected function gradientBackground_clickHandler(event:MouseEvent):void 
{
    mainContainer.setStyle("skinClass", backgroundskin );
}

protected function standardBackground_clickHandler(event:MouseEvent):void
{
    mainContainer.setStyle("skinClass", BorderContainerSkin );
}
```

