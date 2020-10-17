package com.zsz.raiting.top;

import com.zsz.model.TopERPSystem;
import com.zsz.raiting.Sorter;
import com.zsz.raiting.SortingParameters;
import com.zsz.raiting.SystemRanker;

import java.util.List;
import java.util.stream.Collectors;

public class TopSystemsRanker extends SystemRanker<TopERPSystem> implements Sorter {
    public TopSystemsRanker(List<TopERPSystem> systems) {
        super(systems);
    }

    @Override
    public void sortSystems() {
        systems.forEach(system -> system.setTotalScore(calculateTotalScore(system)));

        systems = systems.stream().sorted().collect(Collectors.toList());
    }

    private Double calculateTotalScore(TopERPSystem system){
        return system.getEaseOfUse() * SortingParameters.getEaseMultiplier() +
                system.getValueForMoney() * SortingParameters.getValueMultiplier() +
                system.getCustomerSupport() * SortingParameters.getSupportMultiplier() +
                system.getFunctionality() * SortingParameters.getFunctionalityMultiplier();
    }
}
