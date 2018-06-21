<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="error" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><error:text name="errorPage" /></title>
</head>
<body>
	<error:i18n name="message">
		<error:text name="errorTip" />
	</error:i18n>
	<br />
	<error:property value="exception" />
	<br /> 异常信息：
	<error:property value="exception.message" />
	<br /> 这是测试注解的页面
	<br />
	<error:if test="'foo' in {'foo','bar'}">
		包含在内
	</error:if>
	<error:else>
		不包含
	</error:else>
	<br />
	<error:set var="age" value="18" />
	<error:if test="#age>20">
		青年
	</error:if>
	<error:elseif test="#age>60">
		老年
	</error:elseif>
	<error:else>
		少年
	</error:else>
	<table border="1" width="350">
		<tr>
			<th>序号</th>
			<th>书名</th>
			<th>作者</th>
		</tr>
		<error:iterator
			value="#{'java疯狂讲义':'李刚',
					'python':'李刚','php':'李刚' }"
			status="st" var="book">
			<tr
				<error:if test="#st.odd">
				style="background-color:#aa8800"
				</error:if>>
				<td><error:property value="#st.count" /></td>
				<td><error:property value="key" /></td>
				<td><error:property value="value" /></td>
			</tr>>
		</error:iterator>
	</table>
	<error:append var="newlist">
		<error:param value="{'java','php'}" />
		<error:param value="{'数学','语文'}" />
	</error:append>
	<table border="1" width="50">
		<error:iterator value="#newlist" status="st" var="list">
			<tr
				<error:if test="#st.odd">
				style="background-color:#aa0000"
				</error:if>>
				<td><error:property value="list" /></td>
			</tr>
		</error:iterator>
	</table>
	<table border="1" width="50">
		<error:generator val="'java/php/python'" separator="/">
			<error:iterator status="st">
				<tr
					<error:if test="#st.odd">
				style="background-color:#aa0000"
				</error:if>>
					<td><error:property /></td>
				</tr>
			</error:iterator>
		</error:generator>
	</table>
	<table border="1" width="50">
		<error:subset source="{'java','php','jsp','json'}" start="1" count="3">
			<error:iterator status="st">
				<tr
					<error:if test="#st.odd">
				style="background-color:#aa0000"
				</error:if>>
					<td><error:property /></td>
				</tr>
			</error:iterator>
		</error:subset>
	</table>
	<error:bean var="mydecider" name="com.briup.test.struts.MyDecider" />
	<error:subset source="{'java','php','jsp','json'}" decider="#mydecider" var="set"/>
	${pageScope.set }
	<table border="1" width="50">
			<error:iterator value="#attr.set" status="st" >
				<tr
					<error:if test="#st.odd">
				style="background-color:#aa0000"
				</error:if>>
					<td><error:property/></td>
				</tr>
			</error:iterator>
	</table>
	<error:bean var="mycomparator" name="com.briup.test.struts.MyComparator" />
	<error:sort source="{'java','php','c','python'}" comparator="#mycomparator" var="sort"/>
	<table border="1" width="50">
			<error:iterator value="#attr.sort" status="st" >
				<tr
					<error:if test="#st.odd">
				style="background-color:#aa0000"
				</error:if>>
					<td><error:property/></td>
				</tr>
			</error:iterator>
	</table>
	<error:select theme="lee" list="{'java','php','c','python'}" size="5"/>
	<error:form>
		<error:optiontransferselect 
			label="选择你喜欢的书"
			name="zhbook"
			leftTitle="中文书籍"
			rightTitle="english books"
			addToLeftLabel="向左移动"
			addToRightLabel="向右移动"
			addAllToRightLabel="全部向右移"
			selectAllLabel="全部选择"
			list="{'数学','语文','java疯狂讲义'}" 
			headerKey="zhKey"
			headerValue="选择中文图书"
			emptyOption="true"
			multiple="true"
			doubleList="{'java','python','php'}" 
			doubleName="enbook"
			doubleHeaderKey="enKey"
			doubleHeaderValue="chance english books"
			doubleEmptyOption="true"
			doubleMultiple="true"
			/>
	</error:form>
	<error:if test="hasActionErrors()">
		<error:actionerror/>
	</error:if>
	<error:else>
		<error:actionmessage/>
	</error:else>
</body>
</html>