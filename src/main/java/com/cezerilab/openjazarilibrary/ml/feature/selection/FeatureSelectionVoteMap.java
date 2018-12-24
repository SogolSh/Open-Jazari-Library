/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cezerilab.openjazarilibrary.ml.feature.selection;

import com.cezerilab.openjazarilibrary.utils.CustomComparatorForVoteMap;
import com.cezerilab.openjazarilibrary.factory.FactoryUtils;
import com.cezerilab.openjazarilibrary.types.TVoteMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BAP1
 */
public class FeatureSelectionVoteMap {

    public static Map<String, Double> getVoteMapValue(String features, String ss) {
        String[] fNames = features.split(",");
        Map<String, Double> ret = new HashMap<>();
        for (int i = 0; i < fNames.length; i++) {
            ret.put(fNames[i], 0.0);
        }
        String[] fv = ss.split("\n");
        for (int i = 1; i < fv.length; i++) {
            String[] el = fv[i].split(":");
            String[] f = el[0].split(",");
            double v = Double.parseDouble(el[1]);
            for (int j = 0; j < f.length; j++) {
                double n = ret.get(f[j]) + v;
                ret.put(f[j],FactoryUtils.formatDouble(n,1));
            }
        }
        for (int i = 0; i < fNames.length; i++) {
            ret.put(fNames[i], FactoryUtils.formatDouble(ret.get(fNames[i]) / fv.length,3));
        }
        return ret;
    }
    
    public static ArrayList<TVoteMap> getVoteMapValueByList(String features, String s1) {
        Map<String, Double> vm=getVoteMapValue(features,s1);
        ArrayList<TVoteMap> ret = new ArrayList<>();
        TVoteMap obj;
        Object[] dd = vm.values().toArray();
        double[] d = new double[dd.length];
        for (int i = 0; i < dd.length; i++) {
            d[i] = (double) dd[i];
        }
        double[] votes = d;
        Object[] ss = vm.keySet().toArray();
        String[] s = new String[ss.length];
        for (int i = 0; i < dd.length; i++) {
            s[i] = ss[i] + "";
        }
        String[] fNames = s;
        for (int i = 0; i < vm.size(); i++) {
            obj=new TVoteMap();
            obj.name=fNames[i];
            obj.value=votes[i];
            obj.index=i;
            ret.add(obj);
        }
        Collections.sort(ret,new CustomComparatorForVoteMap());
        return ret;
    }

}
