EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L Device:Q_NPN_BCE Q2
U 1 1 6062332E
P 1400 1650
F 0 "Q2" H 1590 1650 50  0000 L CNN
F 1 "Q_NPN_BCE" H 1591 1605 50  0001 L CNN
F 2 "" H 1600 1750 50  0001 C CNN
F 3 "~" H 1400 1650 50  0001 C CNN
	1    1400 1650
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q1
U 1 1 60623AA5
P 1100 1450
F 0 "Q1" H 1290 1450 50  0000 L CNN
F 1 "Q_NPN_BCE" H 1291 1405 50  0001 L CNN
F 2 "" H 1300 1550 50  0001 C CNN
F 3 "~" H 1100 1450 50  0001 C CNN
	1    1100 1450
	1    0    0    -1  
$EndComp
$Comp
L Device:Battery_Cell BT?
U 1 1 606272C5
P 650 1200
F 0 "BT?" H 768 1296 50  0001 L CNN
F 1 "Battery_Cell" H 768 1205 50  0001 L CNN
F 2 "" V 650 1260 50  0001 C CNN
F 3 "~" V 650 1260 50  0001 C CNN
	1    650  1200
	1    0    0    -1  
$EndComp
Wire Wire Line
	650  1000 650  650 
$Comp
L Device:R R1
U 1 1 60627A33
P 900 1100
F 0 "R1" H 970 1100 50  0000 L CNN
F 1 "R" H 970 1055 50  0001 L CNN
F 2 "" V 830 1100 50  0001 C CNN
F 3 "~" H 900 1100 50  0001 C CNN
	1    900  1100
	1    0    0    -1  
$EndComp
$Comp
L Device:R R2
U 1 1 60627D4A
P 1500 850
F 0 "R2" H 1570 850 50  0000 L CNN
F 1 "R" H 1570 805 50  0001 L CNN
F 2 "" V 1430 850 50  0001 C CNN
F 3 "~" H 1500 850 50  0001 C CNN
	1    1500 850 
	1    0    0    -1  
$EndComp
Wire Wire Line
	900  1250 900  1450
Wire Wire Line
	1500 1000 1500 1150
Wire Wire Line
	1500 1150 1200 1150
Wire Wire Line
	1200 1150 1200 1250
Wire Wire Line
	1500 1150 1500 1450
Connection ~ 1500 1150
Wire Wire Line
	650  1300 650  1950
Wire Wire Line
	650  1950 1500 1950
Wire Wire Line
	1500 1950 1500 1850
Wire Wire Line
	650  650  900  650 
Connection ~ 900  650 
Wire Wire Line
	900  650  900  950 
Wire Wire Line
	900  650  1500 650 
Wire Wire Line
	1500 650  1500 700 
$Comp
L Device:Battery_Cell BT?
U 1 1 6062D4A4
P 1900 1200
F 0 "BT?" H 2018 1296 50  0001 L CNN
F 1 "Battery_Cell" H 2018 1205 50  0001 L CNN
F 2 "" V 1900 1260 50  0001 C CNN
F 3 "~" V 1900 1260 50  0001 C CNN
	1    1900 1200
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q3
U 1 1 6062DA43
P 2350 1500
F 0 "Q3" H 2540 1500 50  0000 L CNN
F 1 "Q_NPN_BCE" H 2541 1455 50  0001 L CNN
F 2 "" H 2550 1600 50  0001 C CNN
F 3 "~" H 2350 1500 50  0001 C CNN
	1    2350 1500
	1    0    0    -1  
$EndComp
Wire Wire Line
	1900 1000 1900 650 
Wire Wire Line
	1900 650  2150 650 
$Comp
L Device:R R3
U 1 1 606309A1
P 2150 1100
F 0 "R3" H 2220 1100 50  0000 L CNN
F 1 "R" H 2220 1055 50  0001 L CNN
F 2 "" V 2080 1100 50  0001 C CNN
F 3 "~" H 2150 1100 50  0001 C CNN
	1    2150 1100
	1    0    0    -1  
$EndComp
$Comp
L Device:R R4
U 1 1 60630FF2
P 2750 800
F 0 "R4" H 2820 800 50  0000 L CNN
F 1 "R" H 2820 755 50  0001 L CNN
F 2 "" V 2680 800 50  0001 C CNN
F 3 "~" H 2750 800 50  0001 C CNN
	1    2750 800 
	1    0    0    -1  
$EndComp
Wire Wire Line
	2150 1500 2150 1250
Wire Wire Line
	2750 1100 2750 950 
Wire Wire Line
	2150 950  2150 650 
Connection ~ 2150 650 
Wire Wire Line
	2150 650  2750 650 
Wire Wire Line
	1900 1300 1900 1950
Wire Wire Line
	1900 1950 2450 1950
Wire Wire Line
	2750 1950 2750 1500
Wire Wire Line
	2450 1700 2450 1950
Connection ~ 2450 1950
Wire Wire Line
	2450 1950 2750 1950
$Comp
L Device:Q_PNP_BCE Q4
U 1 1 6062E145
P 2650 1300
F 0 "Q4" H 2840 1300 50  0000 L CNN
F 1 "Q_PNP_BCE" H 2840 1255 50  0001 L CNN
F 2 "" H 2850 1400 50  0001 C CNN
F 3 "~" H 2650 1300 50  0001 C CNN
	1    2650 1300
	1    0    0    -1  
$EndComp
$Comp
L Device:Battery_Cell BT?
U 1 1 6063967C
P 3250 1600
F 0 "BT?" H 3368 1696 50  0001 L CNN
F 1 "Battery_Cell" H 3368 1605 50  0001 L CNN
F 2 "" V 3250 1660 50  0001 C CNN
F 3 "~" V 3250 1660 50  0001 C CNN
	1    3250 1600
	1    0    0    -1  
$EndComp
$Comp
L Device:R R1
U 1 1 6063A6C5
P 3550 850
F 0 "R1" H 3620 850 50  0000 L CNN
F 1 "R" H 3620 805 50  0001 L CNN
F 2 "" V 3480 850 50  0001 C CNN
F 3 "~" H 3550 850 50  0001 C CNN
	1    3550 850 
	1    0    0    -1  
$EndComp
$Comp
L Device:R R2
U 1 1 6063B21D
P 4000 850
F 0 "R2" H 4070 850 50  0000 L CNN
F 1 "R" H 4070 805 50  0001 L CNN
F 2 "" V 3930 850 50  0001 C CNN
F 3 "~" H 4000 850 50  0001 C CNN
	1    4000 850 
	1    0    0    -1  
$EndComp
Wire Wire Line
	3250 1700 3250 2150
Wire Wire Line
	4000 2150 4000 1850
Wire Wire Line
	4000 1450 4000 1400
Wire Wire Line
	4000 1100 4000 1000
Wire Wire Line
	3550 1100 3550 1000
Wire Wire Line
	3550 1400 3550 1650
Wire Wire Line
	3550 1650 3700 1650
Wire Wire Line
	3250 1400 3250 600 
Wire Wire Line
	3250 600  3550 600 
Wire Wire Line
	3550 600  3550 700 
Wire Wire Line
	3550 600  4000 600 
Wire Wire Line
	4000 600  4000 700 
Connection ~ 3550 600 
Wire Wire Line
	3250 2150 3550 2150
$Comp
L Device:LED D1
U 1 1 60639BE5
P 3550 1250
F 0 "D1" V 3543 1132 50  0000 R CNN
F 1 "LED" V 3498 1132 50  0001 R CNN
F 2 "" H 3550 1250 50  0001 C CNN
F 3 "~" H 3550 1250 50  0001 C CNN
	1    3550 1250
	0    -1   -1   0   
$EndComp
$Comp
L Device:LED D2
U 1 1 6063A313
P 4000 1250
F 0 "D2" V 3993 1132 50  0000 R CNN
F 1 "LED" V 3948 1132 50  0001 R CNN
F 2 "" H 4000 1250 50  0001 C CNN
F 3 "~" H 4000 1250 50  0001 C CNN
	1    4000 1250
	0    -1   -1   0   
$EndComp
$Comp
L Device:Q_NPN_BCE Q1
U 1 1 6063B79D
P 3900 1650
F 0 "Q1" H 4090 1650 50  0000 L CNN
F 1 "Q_NPN_BCE" H 4091 1605 50  0001 L CNN
F 2 "" H 4100 1750 50  0001 C CNN
F 3 "~" H 3900 1650 50  0001 C CNN
	1    3900 1650
	1    0    0    -1  
$EndComp
Wire Wire Line
	3550 1650 3550 2150
Connection ~ 3550 1650
Connection ~ 3550 2150
Wire Wire Line
	3550 2150 4000 2150
NoConn ~ 3550 1850
NoConn ~ 2800 2300
$Comp
L Device:Battery_Cell BT?
U 1 1 6064B376
P 4500 1650
F 0 "BT?" H 4618 1746 50  0001 L CNN
F 1 "Battery_Cell" H 4618 1655 50  0001 L CNN
F 2 "" V 4500 1710 50  0001 C CNN
F 3 "~" V 4500 1710 50  0001 C CNN
	1    4500 1650
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q1
U 1 1 6064BA83
P 4900 1450
F 0 "Q1" H 5090 1450 50  0000 L CNN
F 1 "Q_NPN_BCE" H 5091 1405 50  0001 L CNN
F 2 "" H 5100 1550 50  0001 C CNN
F 3 "~" H 4900 1450 50  0001 C CNN
	1    4900 1450
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q2
U 1 1 6064BD61
P 5200 1800
F 0 "Q2" H 5390 1800 50  0000 L CNN
F 1 "Q_NPN_BCE" H 5391 1755 50  0001 L CNN
F 2 "" H 5400 1900 50  0001 C CNN
F 3 "~" H 5200 1800 50  0001 C CNN
	1    5200 1800
	1    0    0    -1  
$EndComp
$Comp
L Device:Buzzer BZ1
U 1 1 6064DCD3
P 5150 950
F 0 "BZ1" H 5155 1149 50  0000 C CNN
F 1 "Buzzer" H 5155 1149 50  0001 C CNN
F 2 "" V 5125 1050 50  0001 C CNN
F 3 "~" V 5125 1050 50  0001 C CNN
	1    5150 950 
	-1   0    0    -1  
$EndComp
Wire Wire Line
	4500 1450 4500 600 
Wire Wire Line
	4500 600  4700 600 
Wire Wire Line
	5300 600  5300 850 
Wire Wire Line
	5300 850  5250 850 
Wire Wire Line
	5250 1050 5300 1050
Wire Wire Line
	5300 1050 5300 1200
Wire Wire Line
	5300 1200 5000 1200
Wire Wire Line
	5000 1200 5000 1250
Connection ~ 5300 1200
Wire Wire Line
	5300 1200 5300 1600
Wire Wire Line
	5000 1650 5000 1800
$Comp
L Device:R R1
U 1 1 60652258
P 4700 900
F 0 "R1" H 4770 900 50  0000 L CNN
F 1 "R" H 4770 855 50  0001 L CNN
F 2 "" V 4630 900 50  0001 C CNN
F 3 "~" H 4700 900 50  0001 C CNN
	1    4700 900 
	1    0    0    -1  
$EndComp
Wire Wire Line
	4700 750  4700 600 
Connection ~ 4700 600 
Wire Wire Line
	4700 600  5300 600 
Wire Wire Line
	4700 1050 4700 1450
Wire Wire Line
	5300 2000 5300 2150
Wire Wire Line
	5300 2150 4700 2150
Wire Wire Line
	4500 2150 4500 1750
Wire Wire Line
	4700 1450 4700 2150
Connection ~ 4700 1450
Connection ~ 4700 2150
Wire Wire Line
	4700 2150 4500 2150
NoConn ~ 4700 1750
$Comp
L Device:Battery_Cell BT?
U 1 1 60718B78
P 5850 1450
F 0 "BT?" H 5968 1546 50  0001 L CNN
F 1 "Battery_Cell" H 5968 1455 50  0001 L CNN
F 2 "" V 5850 1510 50  0001 C CNN
F 3 "~" V 5850 1510 50  0001 C CNN
	1    5850 1450
	1    0    0    -1  
$EndComp
$Comp
L Device:LED D1
U 1 1 60719AF4
P 6350 900
F 0 "D1" V 6343 782 50  0000 R CNN
F 1 "LED" V 6298 782 50  0001 R CNN
F 2 "" H 6350 900 50  0001 C CNN
F 3 "~" H 6350 900 50  0001 C CNN
	1    6350 900 
	0    -1   -1   0   
$EndComp
$Comp
L Device:LED D7
U 1 1 6071A56D
P 7150 900
F 0 "D7" V 7143 782 50  0000 R CNN
F 1 "LED" V 7098 782 50  0001 R CNN
F 2 "" H 7150 900 50  0001 C CNN
F 3 "~" H 7150 900 50  0001 C CNN
	1    7150 900 
	0    -1   -1   0   
$EndComp
$Comp
L Device:LED D11
U 1 1 6071AA20
P 8100 900
F 0 "D11" V 8093 782 50  0000 R CNN
F 1 "LED" V 8048 782 50  0001 R CNN
F 2 "" H 8100 900 50  0001 C CNN
F 3 "~" H 8100 900 50  0001 C CNN
	1    8100 900 
	0    -1   -1   0   
$EndComp
$Comp
L Device:R R6
U 1 1 6071B036
P 7150 1300
F 0 "R6" H 7220 1300 50  0000 L CNN
F 1 "R" H 7220 1255 50  0001 L CNN
F 2 "" V 7080 1300 50  0001 C CNN
F 3 "~" H 7150 1300 50  0001 C CNN
	1    7150 1300
	1    0    0    -1  
$EndComp
$Comp
L Device:R R10
U 1 1 6071B24C
P 8100 1300
F 0 "R10" H 8170 1300 50  0000 L CNN
F 1 "R" H 8170 1255 50  0001 L CNN
F 2 "" V 8030 1300 50  0001 C CNN
F 3 "~" H 8100 1300 50  0001 C CNN
	1    8100 1300
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q5
U 1 1 6071B439
P 7050 2000
F 0 "Q5" H 7240 2000 50  0000 L CNN
F 1 "Q_NPN_BCE" H 7241 1955 50  0001 L CNN
F 2 "" H 7250 2100 50  0001 C CNN
F 3 "~" H 7050 2000 50  0001 C CNN
	1    7050 2000
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q9
U 1 1 6071B8A3
P 8000 1750
F 0 "Q9" H 8190 1750 50  0000 L CNN
F 1 "Q_NPN_BCE" H 8191 1705 50  0001 L CNN
F 2 "" H 8200 1850 50  0001 C CNN
F 3 "~" H 8000 1750 50  0001 C CNN
	1    8000 1750
	1    0    0    -1  
$EndComp
$Comp
L Device:R R8
U 1 1 60722974
P 7550 1750
F 0 "R8" H 7620 1750 50  0000 L CNN
F 1 "R" H 7620 1705 50  0001 L CNN
F 2 "" V 7480 1750 50  0001 C CNN
F 3 "~" H 7550 1750 50  0001 C CNN
	1    7550 1750
	0    1    1    0   
$EndComp
$Comp
L Device:R R4
U 1 1 60724597
P 6550 2000
F 0 "R4" H 6620 2000 50  0000 L CNN
F 1 "R" H 6620 1955 50  0001 L CNN
F 2 "" V 6480 2000 50  0001 C CNN
F 3 "~" H 6550 2000 50  0001 C CNN
	1    6550 2000
	0    1    1    0   
$EndComp
Wire Wire Line
	7150 1450 7150 1750
Wire Wire Line
	7150 1750 7400 1750
Connection ~ 7150 1750
Wire Wire Line
	7150 1750 7150 1800
Wire Wire Line
	7700 1750 7800 1750
$Comp
L Sensor_Optical:A1050 F2
U 1 1 6072F9FF
P 6350 1400
F 0 "F2" H 6420 1400 50  0000 L CNN
F 1 "A1050" H 6420 1355 50  0001 L CNN
F 2 "OptoDevice:R_LDR_D6.4mm_P3.4mm_Vertical" V 6525 1400 50  0001 C CNN
F 3 "http://cdn-reichelt.de/documents/datenblatt/A500/A106012.pdf" H 6350 1350 50  0001 C CNN
	1    6350 1400
	1    0    0    -1  
$EndComp
Wire Wire Line
	6350 1550 6350 2000
Wire Wire Line
	6350 2000 6400 2000
Wire Wire Line
	6350 1050 6350 1250
Wire Wire Line
	8100 1050 8100 1150
Wire Wire Line
	8100 1450 8100 1500
Wire Wire Line
	7150 1050 7150 1150
$Comp
L Device:R R3
U 1 1 6073811D
P 6350 2250
F 0 "R3" H 6425 2325 50  0000 L CNN
F 1 "R" H 6420 2205 50  0001 L CNN
F 2 "" V 6280 2250 50  0001 C CNN
F 3 "~" H 6350 2250 50  0001 C CNN
	1    6350 2250
	-1   0    0    1   
$EndComp
Wire Wire Line
	6350 2000 6350 2100
Connection ~ 6350 2000
Wire Wire Line
	6350 2400 6350 2500
Wire Wire Line
	8100 2500 8100 1950
Wire Wire Line
	7150 2200 7150 2500
Wire Wire Line
	5850 1250 5850 750 
Wire Wire Line
	5850 750  6350 750 
Wire Wire Line
	5850 1550 5850 2500
Wire Wire Line
	5850 2500 6025 2500
$Comp
L Device:Buzzer BZ12
U 1 1 60740E66
P 8550 1050
F 0 "BZ12" H 8703 1033 50  0000 L CNN
F 1 "Buzzer" H 8702 988 50  0001 L CNN
F 2 "" V 8525 1150 50  0001 C CNN
F 3 "~" V 8525 1150 50  0001 C CNN
	1    8550 1050
	1    0    0    -1  
$EndComp
Wire Wire Line
	8450 750  8450 950 
Wire Wire Line
	8100 750  8450 750 
Wire Wire Line
	8450 1150 8450 1500
Wire Wire Line
	8450 1500 8100 1500
Connection ~ 8100 1500
Wire Wire Line
	8100 1500 8100 1550
Connection ~ 6350 2500
Wire Wire Line
	6350 2500 7150 2500
Connection ~ 7150 2500
Wire Wire Line
	7150 2500 8100 2500
Connection ~ 8100 750 
Wire Wire Line
	7150 750  8100 750 
Connection ~ 7150 750 
Connection ~ 6350 750 
Wire Wire Line
	6350 750  7150 750 
$Comp
L Device:R R13
U 1 1 607544D7
P 6950 1500
F 0 "R13" H 7020 1500 50  0000 L CNN
F 1 "R" H 7020 1455 50  0001 L CNN
F 2 "" V 6880 1500 50  0001 C CNN
F 3 "~" H 6950 1500 50  0001 C CNN
	1    6950 1500
	0    1    1    0   
$EndComp
Wire Wire Line
	6800 2000 6850 2000
Wire Wire Line
	6700 2000 6800 2000
Connection ~ 6800 2000
Wire Wire Line
	6800 1500 6800 2000
Wire Wire Line
	7100 1500 8100 1500
Wire Notes Line
	6750 1425 6750 2075
Wire Notes Line
	6750 2075 6850 2075
Wire Notes Line
	6850 2075 6850 1575
Wire Notes Line
	6850 1575 8150 1575
Wire Notes Line
	8150 1575 8150 1425
Wire Notes Line
	6750 1425 8150 1425
$Comp
L Device:C C14
U 1 1 60778A53
P 6025 2225
F 0 "C14" H 6140 2225 50  0000 L CNN
F 1 "C" H 6140 2180 50  0001 L CNN
F 2 "" H 6063 2075 50  0001 C CNN
F 3 "~" H 6025 2225 50  0001 C CNN
	1    6025 2225
	1    0    0    -1  
$EndComp
Wire Wire Line
	6025 2075 6025 2000
Wire Wire Line
	6025 2000 6350 2000
Wire Wire Line
	6025 2375 6025 2500
Connection ~ 6025 2500
Wire Wire Line
	6025 2500 6350 2500
$EndSCHEMATC
