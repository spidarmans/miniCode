package com.liuhang.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.liuhang.constant.Constants;

public class MiniCodeTest {
	/**
	 * 存放Fizz数字的list集合
	 */
	private List<Integer> fizzList = new ArrayList<Integer>();
	/**
	 * 存放Buzz数字的list集合
	 */
	private List<Integer> buzzList = new ArrayList<Integer>();

	/**
	 * 存放FizzBuzz数字的list集合
	 */
	private List<Integer> fizzBuzzList = new ArrayList<Integer>();
	
	/**
	 * 临时存放游戏规则的结果数字
	 */
	private String tempNum = "";
	@Test
	public void miniCodeTest() {
		/*遍历1-100自然数*/
		for (int num = 1; num <= 100; num++) {
			/*打印1-100游戏结果*/
			printGameNum(num);
			if(fizzBuzzCondition(num)){
				fizzBuzzList.add(num);
				continue ;
			}
			if(fizzCondition(num)){
				fizzList.add(num);
			}
			if(buzzCondition(num)){
				buzzList.add(num);
				continue ;
			}
		}
		fizzList.addAll(fizzBuzzList);
		buzzList.addAll(fizzBuzzList);
		//list排序
		Collections.sort(fizzList);
		Collections.sort(buzzList);
		System.out.println();
		System.out.println("Fizz或含有3的数字个数："+fizzList.size() +"  数值打印："+JSON.toJSONString(fizzList));
		System.out.println("Bizz或含有5的数字个数："+buzzList.size() +"  数值打印："+JSON.toJSONString(buzzList));
		System.out.println("FizzBuzz个数："+fizzBuzzList.size() +"  数值打印："+JSON.toJSONString(fizzBuzzList));
		
	}
	/**
	 * 打印1-100游戏结果
	 * @param num
	 */
	private void printGameNum(int num) {
		tempNum = String.valueOf(num);
		if(num%Constants.FIVE==Constants.ZERO){
			tempNum = Constants.BUZZ;
		}
		if(num%Constants.THREE==Constants.ZERO){
			tempNum = Constants.FIZZ;
		}
		System.out.print(tempNum+" ");
	}
 
	/**
	 * 被5整除或含有5的自然数判断条件
	 * @param num
	 * @return
	 */
	private boolean buzzCondition(int num) {
		return num%Constants.FIVE==Constants.ZERO || String.valueOf(num).indexOf(String.valueOf(Constants.FIVE))>=0;
	}

	/**
	 * 被3整除或含有3的自然数判断条件
	 * @param num
	 * @return
	 */
	private boolean fizzCondition(int num) {
		return num%Constants.THREE==Constants.ZERO || String.valueOf(num).indexOf(String.valueOf(Constants.THREE))>=0;
	}
	
	/**
	 * FizzBuzz判断条件
	 * @param num
	 * @return
	 */
	private boolean fizzBuzzCondition(int num) {
		return (num%Constants.THREE==Constants.ZERO && num%Constants.FIVE==Constants.ZERO) 
				|| (String.valueOf(num).indexOf(String.valueOf(Constants.THREE))>=0 && String.valueOf(num).indexOf(String.valueOf(Constants.FIVE))>=0);
	}

}
