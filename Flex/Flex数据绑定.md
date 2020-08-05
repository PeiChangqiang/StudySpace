# Flex数据绑定

## 一、什么是Flex数据绑定

数据绑定是一个对象的数据绑定到另一个对象的过程。 数据绑定需要**源属性**，**目标属性**和指示**何时**从源到目标复制数据的**触发事件**。

Flex提供了三种方式来执行数据绑定

- MXML脚本中的大括号语法({})
- < fx:binding> 标签
- ActionScript中的BindingUtils



## 二、数据绑定示例

### 1.在mxml中使用花括号

```xml
<s:TextInput id="txtInput1"/>
<s:TextInput id="txtInput2" text = "{txtInput1.text}"/>
```

### 2.使用\<fx:Binding\>标签

```xml
<fx:Binding source="txtInput1.text" destination="txtInput2.text" />
<s:TextInput id="txtInput1"/>
<s:TextInput id="txtInput2"/>
```

### 3.在ActionScript中使用BindingUtils

```xml
<fx:Script>
   <![CDATA[
      import mx.binding.utils.BindingUtils;
      import mx.events.FlexEvent;

      protected function txtInput2_preinitializeHandler(event:FlexEvent):void
      {
         BindingUtils.bindProperty(txtInput2,"text",txtInput1, "text");
      }      
]]>
</fx:Script>
<s:TextInput id="txtInput1"/>
<s:TextInput id="txtInput2" 
preinitialize="txtInput2_preinitializeHandler(event)"/>
```

### 4.三种方式示例代码

```xml
<?xml version="1.0" encoding="utf-8"?>
<s:Application xmlns:fx="http://ns.adobe.com/mxml/2009" 
			   xmlns:s="library://ns.adobe.com/flex/spark" 
			   xmlns:mx="library://ns.adobe.com/flex/mx" minWidth="955" minHeight="600">
	<fx:Declarations>
		<!-- 将非可视元素（例如服务、值对象）放在此处 -->
	</fx:Declarations>
	<fx:Style source="Style.css"/>
	<fx:Script>
		<![CDATA[
			import mx.binding.utils.BindingUtils;   
			import mx.events.FlexEvent;
			
			protected function txtInput6_preinitializeHandler(event:FlexEvent):void
			{
				BindingUtils.bindProperty(txtInput6,"text",txtInput5, "text");
			}
		]]>
	</fx:Script>
	<fx:Binding source="txtInput3.text" destination="txtInput4.text" />
	<s:BorderContainer width="500" height="550" id="mainContainer" styleName="container">
		<s:VGroup width="100%" height="100%" gap="50" horizontalAlign="center" verticalAlign="middle">
			<s:Label id="lblHeader" text="Data Binding Demonstration" fontSize="40" color="0x777777" styleName="heading"/>
            <!--第一种方式-->
			<s:Panel title="Example #1 (使用大括号,\{\})" width="400" height="100" >
				<s:layout>
					<s:VerticalLayout paddingTop="10" paddingLeft="10"/>
				</s:layout>
				<s:HGroup >
					<s:Label text = "Type here: " width="100" paddingTop="6"/>
					<s:TextInput id="txtInput1"/>	
				</s:HGroup>
				<s:HGroup >
					<s:Label text = "Copied text: " width="100" paddingTop="6"/>
					<s:TextInput id="txtInput2" text = "{txtInput1.text}"/>
				</s:HGroup>						
			</s:Panel>
            <!--第二种方式-->
			<s:Panel title="Example #2 (使用 &lt;fx:Binding&gt;)" width="400" height="100" >
				<s:layout>
					<s:VerticalLayout paddingTop="10" paddingLeft="10"/>
				</s:layout>
				<s:HGroup >
					<s:Label text = "Type here: " width="100" paddingTop="6"/>
					<s:TextInput id="txtInput3"/>	
				</s:HGroup>
				<s:HGroup >
					<s:Label text = "Copied text: " width="100" paddingTop="6"/>
					<s:TextInput id="txtInput4"/>
				</s:HGroup>						
			</s:Panel>
            <!--第三种方式-->
			<s:Panel title="Example #3 (使用 BindingUtils)" width="400" height="100" >
				<s:layout>
					<s:VerticalLayout paddingTop="10" paddingLeft="10"/>
				</s:layout>
				<s:HGroup >
					<s:Label text = "Type here: " width="100" paddingTop="6"/>
					<s:TextInput id="txtInput5"/>	
				</s:HGroup>
				<s:HGroup >
					<s:Label text = "Copied text: " width="100" paddingTop="6"/>
					<s:TextInput enabled="false" id="txtInput6" preinitialize="txtInput6_preinitializeHandler(event)"/>
				</s:HGroup>						
			</s:Panel>
		</s:VGroup>	 
	</s:BorderContainer>	
</s:Application>
```

