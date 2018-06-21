package com.briup.expression;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ExpressionContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.briup.bean.Person;

public class ExpressionTest {
	public static void main(String[] args) {
		ExpressionParser ep = new SpelExpressionParser();
		Expression expression = ep.parseExpression("'miner'");
		System.out.println(expression.getValue());
		expression=ep.parseExpression("'miner'.concat('!')");
		System.out.println(expression.getValue());
		expression=ep.parseExpression("'miner'.bytes");
		System.out.println(expression.getValue());
		expression=ep.parseExpression("'miner'.bytes.length");
		System.out.println(expression.getValue());
		expression=ep.parseExpression("new String('miner').toUpperCase()");
		System.out.println(expression.getValue(String.class));
		Person person = new Person("myminer", "20");
		expression=ep.parseExpression("name");
		System.out.println(expression.getValue(person,String.class));
		expression=ep.parseExpression("name=='myminer'");
		StandardEvaluationContext sec = new StandardEvaluationContext();
		sec.setRootObject(person);
		System.out.println(expression.getValue(sec,Boolean.class));
		List<String> list = new ArrayList<String>();
		list.add("miner");
		list.add("is");
		list.add("my");
		EvaluationContext ext = new StandardEvaluationContext();
		ext.setVariable("lists", list);
		System.out.println(ep.parseExpression("#lists[1]").getValue(ext));
		System.out.println(ep.parseExpression("#lists.![length()]").getValue(ext));
	}
}
