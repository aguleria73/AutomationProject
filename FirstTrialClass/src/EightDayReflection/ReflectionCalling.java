package EightDayReflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionCalling {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException  {
		String OperationType = "Divison";
		int x = 3;
		int y = 2;
		
		Opertions opt = new Opertions();
		Method m = opt.getClass().getMethod(OperationType, int.class, int.class);
		m.invoke(opt, x, y);
		
		
		
		// 
		Class<?> cls = Class.forName("EightDayReflection.Opertions");
		Object obj = cls.getDeclaredConstructor().newInstance();
		Method md = cls.getMethod("getname");
		md.invoke(obj);
		
		//Access Private variable 
		Field f = cls.getDeclaredField("name");
		f.setAccessible(true);
		f.set(obj, "Guleria");
		md.invoke(obj);
		
		
		
//		if(OperationType.equals("Add")) {
//			opt.Add(x, y);
//			
//		}else if (OperationType.equals("Minus")) {
//			opt.Minus(x, y);
//			
//		}else if (OperationType.equals("Multiply")) {
//			opt.Multiply(x, y);
//			
//		}else if (OperationType.equals("Divison")) {
//			opt.Divison(x, y);
//		}

	}

}
