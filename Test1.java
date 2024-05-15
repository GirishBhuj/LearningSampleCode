package GBSoft.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.openqa.selenium.Keys;

public class Test1 {
	
	public static void main(String str)
	{
		System.out.println("in second main");
		
	}


	
	public static void main(String[] args)
	{	
		Interview mInv = new Interview();
		//mInv.m2 ();
		//mInv.m3();

		ArrayList<Integer> mArrayList = new ArrayList<Integer>
		(Arrays.asList(23,54,539,23,54,58,24,25));
		
		LinkedHashSet<Integer> mLinkedHashSet = new LinkedHashSet<>(mArrayList);
		ArrayList<Integer> mArrayList1 = new ArrayList<Integer>(mLinkedHashSet);
		System.out.println(mArrayList1);
		
		ArrayList<String> mStrArrayList = new ArrayList<String> (Arrays.asList("Anju","Manju","Sanju"));

		LinkedHashSet<String> mStrLinkedHashSet = new LinkedHashSet<String>(mStrArrayList);
		ArrayList<String> mStrArrayList1 = new ArrayList<String>(mStrLinkedHashSet);
		System.out.println(mStrArrayList1);
		
		HashSet<String> mSet = new HashSet<>();
		mSet.add("abc");
		mSet.add("xyz");
		mSet.add("pqr");
		
		for(String str:mSet)
		{
			System.out.println(str);
		}
		
		
        HashMap<String,String> mCapitals = new HashMap<>();
        mCapitals.put("India","New Delhi");
        mCapitals.put("Russia","Moscow");
        mCapitals.put("Shrilanka","Colombo");

        for (String mVar:mCapitals.keySet()) {
        	System.out.println(mCapitals.get(mVar));
        	//System.out.println(mVar);
        	}

        for (String mValue : mCapitals.values()) {System.out.println(mValue);}
     
		String str1 = "hi";		
		Test1 mTest1 = new Test1();
		mTest1.main(str1);

	}
}
