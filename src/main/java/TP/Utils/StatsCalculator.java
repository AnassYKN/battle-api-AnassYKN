package TP.Utils;

import org.springframework.stereotype.Service;

@Service
public class StatsCalculator {

    public StatsCalculator() {}

    public int calculateStat(int baseStat, int level){
        return 5 + (baseStat * ( level / 50 ));
    }

    public int calculateHP(int baseStat, int level){
        return 10 + level + ( baseStat * ( level / 50));
    }

}
