package com.GeneAlgo.KnapSack.AlgoService;

import org.springframework.stereotype.Service;

import com.GeneAlgo.KnapSack.Entity.AlgoControls;

@Service
public class RunAlgorithmService {

	public Generation runAlgorithm() {
		newMain newMain = new newMain();
		return newMain.returnMain();
	}
	
	public Generation customRunAlgorithm(AlgoControls algoControl) {
		newMain newMain = new newMain();
		return newMain.customSetup(algoControl);
	}
	
}
