package com.mymin.sort;

public class Sort {
	private static char[] charStr = { '1', '2' };

	public static void main(String[] args) {
		perm(charStr, 0, charStr.length - 1);
	}

	public static void perm(char[] buf, int start, int end) {
		if (start == end) {// ��ֻҪ���������һ����ĸ����ȫ����ʱ��ֻҪ�Ͱ�������������ɣ����������
			for (int i = 0; i <= end; i++) {
				System.out.print(buf[i]);
			}
			System.out.println();
		} else {// �����ĸȫ���У��ձ������
			for (int i = start; i <= end; i++) {// ����ָ��start�ֱ�ָ��ÿһ������
				char temp = buf[start];// ���������һ��Ԫ���������Ԫ��
				buf[start] = buf[i];
				buf[i] = temp;
				
				perm(buf, start + 1, end);// ����Ԫ�صݹ�ȫ����
				
				temp = buf[start];// ������������黹ԭ
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}
}
