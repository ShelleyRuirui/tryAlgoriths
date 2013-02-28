package dynamic;

import java.util.ArrayList;

public class CalcStringEditDistance {

	public static int computeEditDistance(String s1, String s2) {
		int result = -1;

		if (s1.equals(s2))
			return 0;

		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();

		int length1 = s1.length();
		int length2 = s2.length();

		// Init the midResult matrix
		int[][] midResult = new int[length1 + 1][length2 + 1];
		StringBuilder modifyType = new StringBuilder();

		int count = 0;
		for (int i = 0; i < s1.length() + 1; i++) {
			midResult[i][0] = count;
			count++;
		}
		count = 0;
		for (int j = 0; j < s2.length() + 1; j++) {
			midResult[0][j] = count;
			count++;
		}

		// Compute from the substring to the whole string and store the mid
		// result

		for (int i = 1; i < length1 + 1; i++) {
			for (int j = 1; j < length2 + 1; j++) {
				int temp1 = midResult[i - 1][j] + 1; // This represents the
														// delete behavior
				int temp2 = midResult[i][j - 1] + 1;// This represents the
													// add behavior
				int temp3 = midResult[i - 1][j - 1]; // This represents the
														// substitution behavior
				if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
					temp3 += 1;
				}

				temp1 = Math.min(temp1, temp2);
				midResult[i][j] = Math.min(temp1, temp3);
			}
		}

		//Till here the distance count is calculated. Now continue to compute the change steps
		for (int i = 0; i < length1 + 1; i++) {
			for (int j = 0; j < length2 + 1; j++) {
				System.out.print(midResult[i][j] + " ");
			}
			System.out.println();
		}

		int iIndex = length1;
		int jIndex = length2;
		while (iIndex != 0 && jIndex != 0) {
			if (midResult[iIndex][jIndex] == midResult[iIndex - 1][jIndex] + 1) {
				modifyType.insert(0, 0);
				iIndex = iIndex - 1;
			} else if (midResult[iIndex][jIndex] == midResult[iIndex][jIndex - 1] + 1) {
				modifyType.insert(0, 1);
				jIndex = jIndex - 1;
			} else {
				modifyType.insert(0, 2);
				iIndex = iIndex - 1;
				jIndex = jIndex - 1;
			}
		}

		System.out.println(modifyType);

		ArrayList<String> midStrings = new ArrayList<String>();
		midStrings.add(s2);
		StringBuilder prevBackResult = new StringBuilder(s2);
		int i = length1 - 1;
		int j = length2 - 1;
		int currentPos = length2 - 1;
		String prev = "";
		String cur = "";

		for (int index = modifyType.length() - 1; index >= 1; index--) {
			int modify = Integer.parseInt(modifyType.charAt(index) + "");
			switch (modify) {
			case 0:
				prev = prevBackResult.toString();
				prevBackResult.insert(currentPos + 1, s1.charAt(i));
				cur = prevBackResult.toString();
				if (!prev.equals(cur))
					midStrings.add(cur);
				i--;
				break;
			case 1:
				prev = prevBackResult.toString();
				prevBackResult.deleteCharAt(currentPos);
				cur = prevBackResult.toString();
				if (!prev.equals(cur))
					midStrings.add(cur);
				currentPos--;
				j--;
				break;
			case 2:
				prev = prevBackResult.toString();
				prevBackResult.deleteCharAt(currentPos);
				prevBackResult.insert(currentPos, s1.charAt(i));
				cur = prevBackResult.toString();
				if (!prev.equals(cur))
					midStrings.add(cur);
				currentPos--;
				i--;
				j--;
			}
		}

		for (int k = midStrings.size() - 1; k >= 0; k--) {
			System.out.println(midStrings.get(k));
		}

		return midResult[length1][length2];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeEditDistance("snowy", "sunnwy"));
	}

}
