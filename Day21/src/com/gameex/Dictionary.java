package com.gameex;

public class Dictionary extends PairMap {

	protected int cnt = 0;

	public Dictionary(int capacity) {
		keyArray = new String[capacity];
		valueArray = new String[capacity];
	}

	@Override
	String get(String key) {

		for (int i = 0; i < cnt; i++) {
			if (keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}

		// 현재 배열에 저장된 원소 개수만큼 반복하면 됨
		return null; // key 값이 없을때
	}

	@Override
	void put(String key, String value) {

		int i = 0;

		for (i = 0; i < cnt; i++) {
			if (keyArray[i].equals(key))

				break;

		}

		if (i == cnt) {// 키 값을 찾지 못했을 경우
			if (i < keyArray.length) { // 배열이 차지 않았을 경우 cnt 장가
				keyArray[i] = key;
				valueArray[i] = value;
				cnt++;
			}

		} else { // 키 값을 발견했으나 값이 수정된 경우 cnt는 증가하지 않음

			keyArray[i] = key;
			valueArray[i] = value;

		}

	}

	@Override
	String delete(String key) {

		int i = 0;

		for (i = 0; i < cnt; i++) {
			if (keyArray[i].equals(key))

				break;

		}

		if (i == cnt) {

			return null;

		} 

		String value = valueArray[i];
		//앞으로 자리 이동한다 (감소)
		cnt--;
		int last = cnt -1;
		for(int j = i; j < last; j++) {
			keyArray[j] = keyArray[j+1];
			valueArray[j] = valueArray[j+1];
		}
		cnt--;
		return value;

	}

	@Override
	int length() {
		// TODO Auto-generated method stub
		return cnt;
	}

}
