package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarCompareTest {

	public static void main(String[] args) {
		Car car1 = new Car(2460, "SonataB", "HD");
		Car car2 = new Car(1297, "K8", "KIA");
		Car car3 = new Car(3487, "QM6", "SS");
		Car car4 = new Car(6087, "SonataA", "HD");
		Car car5 = new Car(2678, "XM3", "SS");
		Car car6 = new Car(2469, "K5", "KIA");
		Car car7 = new Car(9987, "GENESIS", "HD");
		Car car8 = new Car(7777, "Avante", "HD");
		Car car9 = new Car(3333, "SM6", "SS");
		Car car10 = new Car(1845, "K5D", "KIA");

		List<Car> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		list.add(car9);
		list.add(car10);
		view(list);

		System.out.println(" >>>>>>>>>>>>>  차번호로 정렬 후 결과 ");
		Collections.sort(list);
		view(list);

		System.out.println(" >>>>>>>>>>>>>  차이름으로 정렬 후 결과 ");
		Comparator<Car> carCompare = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				if (c1.getCarName().compareTo(c2.getCarName()) > 0) {
					return 1; // 오름차순
//				return -1;  // 내림차순;
				} else if (c1.getCarName().compareTo(c2.getCarName()) < 0) {
					return -1; // 오름차순
//				return 1;  // 내림차순
				} else {
					return 1;
				}
			}

		};
		Collections.sort(list);
		view(list);

		System.out.println(" >>>>>>>>>>>>>  제조사로 정렬 후 결과 ");
		Comparator<Car> carMakerCompare = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				if (c1.getMaker().compareTo(c2.getMaker()) > 0) {
					return 1; // 오름차순
//				return -1;  // 내림차순;
				} else if (c1.getMaker().compareTo(c2.getMaker()) < 0) {
					return -1; // 오름차순
//				return 1;  // 내림차순
				} else {
					return 1;
				}
			}

		};
		Collections.sort(list);
		view(list);
	}

	private static void view(List<Car> list) {
		System.out.println("자번호\t차이름\t제조사");
		for (Car car : list) {
			System.out.println(car);
		}
	}
}
