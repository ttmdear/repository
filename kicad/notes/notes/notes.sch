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
P 1950 2050
F 0 "Q2" H 2140 2050 50  0000 L CNN
F 1 "Q_NPN_BCE" H 2141 2005 50  0001 L CNN
F 2 "" H 2150 2150 50  0001 C CNN
F 3 "~" H 1950 2050 50  0001 C CNN
	1    1950 2050
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q1
U 1 1 60623AA5
P 1650 1850
F 0 "Q1" H 1840 1850 50  0000 L CNN
F 1 "Q_NPN_BCE" H 1841 1805 50  0001 L CNN
F 2 "" H 1850 1950 50  0001 C CNN
F 3 "~" H 1650 1850 50  0001 C CNN
	1    1650 1850
	1    0    0    -1  
$EndComp
$Comp
L Device:Battery_Cell BT?
U 1 1 606272C5
P 1200 1600
F 0 "BT?" H 1318 1696 50  0001 L CNN
F 1 "Battery_Cell" H 1318 1605 50  0001 L CNN
F 2 "" V 1200 1660 50  0001 C CNN
F 3 "~" V 1200 1660 50  0001 C CNN
	1    1200 1600
	1    0    0    -1  
$EndComp
Wire Wire Line
	1200 1400 1200 1050
$Comp
L Device:R R1
U 1 1 60627A33
P 1450 1500
F 0 "R1" H 1520 1500 50  0000 L CNN
F 1 "R" H 1520 1455 50  0001 L CNN
F 2 "" V 1380 1500 50  0001 C CNN
F 3 "~" H 1450 1500 50  0001 C CNN
	1    1450 1500
	1    0    0    -1  
$EndComp
$Comp
L Device:R R2
U 1 1 60627D4A
P 2050 1250
F 0 "R2" H 2120 1250 50  0000 L CNN
F 1 "R" H 2120 1205 50  0001 L CNN
F 2 "" V 1980 1250 50  0001 C CNN
F 3 "~" H 2050 1250 50  0001 C CNN
	1    2050 1250
	1    0    0    -1  
$EndComp
Wire Wire Line
	1450 1650 1450 1850
Wire Wire Line
	2050 1400 2050 1550
Wire Wire Line
	2050 1550 1750 1550
Wire Wire Line
	1750 1550 1750 1650
Wire Wire Line
	2050 1550 2050 1850
Connection ~ 2050 1550
Wire Wire Line
	1200 1700 1200 2350
Wire Wire Line
	1200 2350 2050 2350
Wire Wire Line
	2050 2350 2050 2250
Wire Wire Line
	1200 1050 1450 1050
Connection ~ 1450 1050
Wire Wire Line
	1450 1050 1450 1350
Wire Wire Line
	1450 1050 2050 1050
Wire Wire Line
	2050 1050 2050 1100
$Comp
L Device:Battery_Cell BT?
U 1 1 6062D4A4
P 2450 1600
F 0 "BT?" H 2568 1696 50  0001 L CNN
F 1 "Battery_Cell" H 2568 1605 50  0001 L CNN
F 2 "" V 2450 1660 50  0001 C CNN
F 3 "~" V 2450 1660 50  0001 C CNN
	1    2450 1600
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q3
U 1 1 6062DA43
P 2900 1900
F 0 "Q3" H 3090 1900 50  0000 L CNN
F 1 "Q_NPN_BCE" H 3091 1855 50  0001 L CNN
F 2 "" H 3100 2000 50  0001 C CNN
F 3 "~" H 2900 1900 50  0001 C CNN
	1    2900 1900
	1    0    0    -1  
$EndComp
Wire Wire Line
	2450 1400 2450 1050
Wire Wire Line
	2450 1050 2700 1050
$Comp
L Device:R R3
U 1 1 606309A1
P 2700 1500
F 0 "R3" H 2770 1500 50  0000 L CNN
F 1 "R" H 2770 1455 50  0001 L CNN
F 2 "" V 2630 1500 50  0001 C CNN
F 3 "~" H 2700 1500 50  0001 C CNN
	1    2700 1500
	1    0    0    -1  
$EndComp
$Comp
L Device:R R4
U 1 1 60630FF2
P 3300 1200
F 0 "R4" H 3370 1200 50  0000 L CNN
F 1 "R" H 3370 1155 50  0001 L CNN
F 2 "" V 3230 1200 50  0001 C CNN
F 3 "~" H 3300 1200 50  0001 C CNN
	1    3300 1200
	1    0    0    -1  
$EndComp
Wire Wire Line
	2700 1900 2700 1650
Wire Wire Line
	3300 1500 3300 1350
Wire Wire Line
	2700 1350 2700 1050
Connection ~ 2700 1050
Wire Wire Line
	2700 1050 3300 1050
Wire Wire Line
	2450 1700 2450 2350
Wire Wire Line
	2450 2350 3000 2350
Wire Wire Line
	3300 2350 3300 1900
Wire Wire Line
	3000 2100 3000 2350
Connection ~ 3000 2350
Wire Wire Line
	3000 2350 3300 2350
$Comp
L Device:Q_PNP_BCE Q4
U 1 1 6062E145
P 3200 1700
F 0 "Q4" H 3390 1700 50  0000 L CNN
F 1 "Q_PNP_BCE" H 3390 1655 50  0001 L CNN
F 2 "" H 3400 1800 50  0001 C CNN
F 3 "~" H 3200 1700 50  0001 C CNN
	1    3200 1700
	1    0    0    -1  
$EndComp
$Comp
L Device:Battery_Cell BT?
U 1 1 6063967C
P 3800 2000
F 0 "BT?" H 3918 2096 50  0001 L CNN
F 1 "Battery_Cell" H 3918 2005 50  0001 L CNN
F 2 "" V 3800 2060 50  0001 C CNN
F 3 "~" V 3800 2060 50  0001 C CNN
	1    3800 2000
	1    0    0    -1  
$EndComp
$Comp
L Device:R R1
U 1 1 6063A6C5
P 4100 1250
F 0 "R1" H 4170 1250 50  0000 L CNN
F 1 "R" H 4170 1205 50  0001 L CNN
F 2 "" V 4030 1250 50  0001 C CNN
F 3 "~" H 4100 1250 50  0001 C CNN
	1    4100 1250
	1    0    0    -1  
$EndComp
$Comp
L Device:R R2
U 1 1 6063B21D
P 4550 1250
F 0 "R2" H 4620 1250 50  0000 L CNN
F 1 "R" H 4620 1205 50  0001 L CNN
F 2 "" V 4480 1250 50  0001 C CNN
F 3 "~" H 4550 1250 50  0001 C CNN
	1    4550 1250
	1    0    0    -1  
$EndComp
Wire Wire Line
	3800 2100 3800 2550
Wire Wire Line
	4550 2550 4550 2250
Wire Wire Line
	4550 1850 4550 1800
Wire Wire Line
	4550 1500 4550 1400
Wire Wire Line
	4100 1500 4100 1400
Wire Wire Line
	4100 1800 4100 2050
Wire Wire Line
	4100 2050 4250 2050
Wire Wire Line
	3800 1800 3800 1000
Wire Wire Line
	3800 1000 4100 1000
Wire Wire Line
	4100 1000 4100 1100
Wire Wire Line
	4100 1000 4550 1000
Wire Wire Line
	4550 1000 4550 1100
Connection ~ 4100 1000
Wire Wire Line
	3800 2550 4100 2550
$Comp
L Device:LED D1
U 1 1 60639BE5
P 4100 1650
F 0 "D1" V 4093 1532 50  0000 R CNN
F 1 "LED" V 4048 1532 50  0001 R CNN
F 2 "" H 4100 1650 50  0001 C CNN
F 3 "~" H 4100 1650 50  0001 C CNN
	1    4100 1650
	0    -1   -1   0   
$EndComp
$Comp
L Device:LED D2
U 1 1 6063A313
P 4550 1650
F 0 "D2" V 4543 1532 50  0000 R CNN
F 1 "LED" V 4498 1532 50  0001 R CNN
F 2 "" H 4550 1650 50  0001 C CNN
F 3 "~" H 4550 1650 50  0001 C CNN
	1    4550 1650
	0    -1   -1   0   
$EndComp
$Comp
L Device:Q_NPN_BCE Q1
U 1 1 6063B79D
P 4450 2050
F 0 "Q1" H 4640 2050 50  0000 L CNN
F 1 "Q_NPN_BCE" H 4641 2005 50  0001 L CNN
F 2 "" H 4650 2150 50  0001 C CNN
F 3 "~" H 4450 2050 50  0001 C CNN
	1    4450 2050
	1    0    0    -1  
$EndComp
Wire Wire Line
	4100 2050 4100 2550
Connection ~ 4100 2050
Connection ~ 4100 2550
Wire Wire Line
	4100 2550 4550 2550
NoConn ~ 4100 2250
NoConn ~ 3350 2700
$Comp
L Device:Battery_Cell BT?
U 1 1 6064B376
P 5050 2050
F 0 "BT?" H 5168 2146 50  0001 L CNN
F 1 "Battery_Cell" H 5168 2055 50  0001 L CNN
F 2 "" V 5050 2110 50  0001 C CNN
F 3 "~" V 5050 2110 50  0001 C CNN
	1    5050 2050
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q1
U 1 1 6064BA83
P 5450 1850
F 0 "Q1" H 5640 1850 50  0000 L CNN
F 1 "Q_NPN_BCE" H 5641 1805 50  0001 L CNN
F 2 "" H 5650 1950 50  0001 C CNN
F 3 "~" H 5450 1850 50  0001 C CNN
	1    5450 1850
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q2
U 1 1 6064BD61
P 5750 2200
F 0 "Q2" H 5940 2200 50  0000 L CNN
F 1 "Q_NPN_BCE" H 5941 2155 50  0001 L CNN
F 2 "" H 5950 2300 50  0001 C CNN
F 3 "~" H 5750 2200 50  0001 C CNN
	1    5750 2200
	1    0    0    -1  
$EndComp
$Comp
L Device:Buzzer BZ1
U 1 1 6064DCD3
P 5700 1350
F 0 "BZ1" H 5705 1549 50  0000 C CNN
F 1 "Buzzer" H 5705 1549 50  0001 C CNN
F 2 "" V 5675 1450 50  0001 C CNN
F 3 "~" V 5675 1450 50  0001 C CNN
	1    5700 1350
	-1   0    0    -1  
$EndComp
Wire Wire Line
	5050 1850 5050 1000
Wire Wire Line
	5050 1000 5250 1000
Wire Wire Line
	5850 1000 5850 1250
Wire Wire Line
	5850 1250 5800 1250
Wire Wire Line
	5800 1450 5850 1450
Wire Wire Line
	5850 1450 5850 1600
Wire Wire Line
	5850 1600 5550 1600
Wire Wire Line
	5550 1600 5550 1650
Connection ~ 5850 1600
Wire Wire Line
	5850 1600 5850 2000
Wire Wire Line
	5550 2050 5550 2200
$Comp
L Device:R R1
U 1 1 60652258
P 5250 1300
F 0 "R1" H 5320 1300 50  0000 L CNN
F 1 "R" H 5320 1255 50  0001 L CNN
F 2 "" V 5180 1300 50  0001 C CNN
F 3 "~" H 5250 1300 50  0001 C CNN
	1    5250 1300
	1    0    0    -1  
$EndComp
Wire Wire Line
	5250 1150 5250 1000
Connection ~ 5250 1000
Wire Wire Line
	5250 1000 5850 1000
Wire Wire Line
	5250 1450 5250 1850
Wire Wire Line
	5850 2400 5850 2550
Wire Wire Line
	5850 2550 5250 2550
Wire Wire Line
	5050 2550 5050 2150
Wire Wire Line
	5250 1850 5250 2550
Connection ~ 5250 1850
Connection ~ 5250 2550
Wire Wire Line
	5250 2550 5050 2550
NoConn ~ 5250 2150
$EndSCHEMATC