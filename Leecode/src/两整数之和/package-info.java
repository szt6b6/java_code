package 两整数之和;

/*
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3

示例 2:

输入: a = -2, b = 3
输出: 1

用位运算实现加法<https://blog.csdn.net/YPJMFC/article/details/78246971>
1.无进位所加和sum=a^b
2.进位carry=(a&b) << 1
3.a=sum,b=carry

进位标志不为0,循环操作

*/