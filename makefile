all:
	ant run
	zip -d logisim-evolution.jar 'META-INF/*.SF' 'META-INF/*.RSA' 'META-INF/*SF'
	
upload:
	scp logisim-evolution.jar sderrien@cassius.istic.univ-rennes1.fr:/share/l3info/PFO
	scp logisim-evolution.jar sderrien@cassius.istic.univ-rennes1.fr:/share/l2ie/sen2/logisim	
	scp logisim-evolution.jar sderrien@cassius.istic.univ-rennes1.fr:/share/m2et/ACMAT/logisim