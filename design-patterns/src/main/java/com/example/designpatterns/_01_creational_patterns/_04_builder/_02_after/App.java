package com.example.designpatterns._01_creational_patterns._04_builder._02_after;

import com.example.designpatterns._01_creational_patterns._04_builder._01_before.TourPlan;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        DefaultTourBuilder builder = new DefaultTourBuilder();
        TourPlan longBeachTrip = builder.title("롱비치")
                .startDate(LocalDate.of(2022, 12, 31))
                .getPlan();

        TourPlan plan = builder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 1, 1))
                .whereToStay("리조트")
                .addPlan(0, "체크인 이후 짐풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();


        // 디렉터 적용
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan1 = director.cancunTrip();
        TourPlan tourPlan2 = director.longBeachTrip();
    }
}
