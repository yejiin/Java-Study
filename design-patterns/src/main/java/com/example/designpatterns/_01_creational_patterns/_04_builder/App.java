package com.example.designpatterns._01_creational_patterns._04_builder;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        // 빌더 패턴 적용 전
        TourPlan shortTrip = new TourPlan();
        shortTrip.setTitle("오레곤 롱비치 여행");
        shortTrip.setStartDate(LocalDate.of(2022, 12, 31));

        TourPlan tourPlan = new TourPlan();
        tourPlan.setTitle("칸쿤 여행");
        tourPlan.setNights(2);
        tourPlan.setDays(3);
        tourPlan.setStartDate(LocalDate.of(2022, 1, 1));
        tourPlan.setWhereToStay("리조트");
        tourPlan.addPlan(0, "체크인 이후 짐풀기");
        tourPlan.addPlan(0, "저녁 식사");
        tourPlan.addPlan(1, "조식 뷔페에서 식사");
        tourPlan.addPlan(1, "해변가 산책");
        tourPlan.addPlan(1, "점심은 수영장 근처 음식점에서 먹기");
        tourPlan.addPlan(1, "리조트 수영장에서 놀기");
        tourPlan.addPlan(1, "저녁은 BBQ 식당에서 스테이크");
        tourPlan.addPlan(2, "조식 뷔페에서 식사");
        tourPlan.addPlan(2, "체크아웃");


        // 빌더 패턴 적용 후
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
