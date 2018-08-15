package com.jbbwebsolutions.pseudo.model;
public class Foo
{
    public static int getNum()
    {
      return 15;
    }
    
    public static int getNum(int x )
    {
      return 5 * x ;
    }
    
    public static int mult(int a, int b )
    {
      return a * b ;
    }
    
    public static int add(int a, int b )
    {
      return a + b ;
    }
    
    
    public static String getNum(String mode , int x )
    {
      return mode + x ;
    }
}