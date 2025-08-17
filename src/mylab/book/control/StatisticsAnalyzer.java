package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPrices.put(type, totalPrices.getOrDefault(type, 0.0) + pub.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averagePrices = new HashMap<>();
        for (String type : totalPrices.keySet()) {
            averagePrices.put(type, totalPrices.get(type) / counts.get(type));
        }
        return averagePrices;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        int totalCount = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : counts.keySet()) {
            distribution.put(type, (double) counts.get(type) / totalCount * 100);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count / publications.length * 100;
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###");
        DecimalFormat percentDf = new DecimalFormat("0.00");

        System.out.println("===== 출판물 통계 분석 =====");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }
        System.out.println();

        System.out.println("2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + percentDf.format(entry.getValue()) + "%");
        }
        System.out.println();

        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율: " + percentDf.format(ratio2007) + "%");
    }
}