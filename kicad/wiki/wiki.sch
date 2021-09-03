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
L MCU_Microchip_ATmega:ATmega8-16AU U?
U 1 1 6132D9D8
P 2150 1250
F 0 "U?" V 2150 2694 50  0001 L CNN
F 1 "ATmega8-16AU" V 2195 2694 50  0001 L CNN
F 2 "Package_QFP:TQFP-32_7x7mm_P0.8mm" H 2150 1250 50  0001 C CIN
F 3 "http://ww1.microchip.com/downloads/en/DeviceDoc/atmel-2486-8-bit-avr-microcontroller-atmega8_l_datasheet.pdf" H 2150 1250 50  0001 C CNN
	1    2150 1250
	0    1    1    0   
$EndComp
$Comp
L power:+5V #PWR?
U 1 1 61331C6F
P 4000 1000
F 0 "#PWR?" H 4000 850 50  0001 C CNN
F 1 "+5V" H 4015 1173 50  0000 C CNN
F 2 "" H 4000 1000 50  0001 C CNN
F 3 "" H 4000 1000 50  0001 C CNN
	1    4000 1000
	1    0    0    -1  
$EndComp
Wire Wire Line
	4000 1250 4000 1000
Wire Wire Line
	3550 1250 4000 1250
$Comp
L Switch:SW_DIP_x01 SW?
U 1 1 61332F5D
P 3700 2000
F 0 "SW?" H 3700 2175 50  0001 C CNN
F 1 "SW_DIP_x01" H 3700 2176 50  0001 C CNN
F 2 "" H 3700 2000 50  0001 C CNN
F 3 "~" H 3700 2000 50  0001 C CNN
	1    3700 2000
	1    0    0    -1  
$EndComp
Wire Wire Line
	4000 1250 4000 2000
Connection ~ 4000 1250
Wire Wire Line
	3250 1850 3250 2000
Wire Wire Line
	3250 2000 3400 2000
$Comp
L Device:R R1
U 1 1 61333C87
P 3250 2150
F 0 "R1" H 3320 2196 50  0000 L CNN
F 1 "10k" H 3320 2105 50  0000 L CNN
F 2 "" V 3180 2150 50  0001 C CNN
F 3 "~" H 3250 2150 50  0001 C CNN
	1    3250 2150
	1    0    0    -1  
$EndComp
Connection ~ 3250 2000
$Comp
L power:GND #PWR?
U 1 1 613340A0
P 3250 2500
F 0 "#PWR?" H 3250 2250 50  0001 C CNN
F 1 "GND" H 3255 2327 50  0000 C CNN
F 2 "" H 3250 2500 50  0001 C CNN
F 3 "" H 3250 2500 50  0001 C CNN
	1    3250 2500
	1    0    0    -1  
$EndComp
Wire Wire Line
	3250 2300 3250 2350
$Comp
L Device:C C1
U 1 1 61334B44
P 3100 2000
F 0 "C1" V 3150 2300 50  0000 C CNN
F 1 "100n" V 3050 2300 50  0000 C CNN
F 2 "" H 3138 1850 50  0001 C CNN
F 3 "~" H 3100 2000 50  0001 C CNN
	1    3100 2000
	0    -1   -1   0   
$EndComp
Wire Wire Line
	2950 2000 2950 2350
Wire Wire Line
	2950 2350 3250 2350
Connection ~ 3250 2350
Wire Wire Line
	3250 2350 3250 2500
Text Notes 850  600  0    50   ~ 0
Stan niski wejścia
$Comp
L Relay:DIPxx-1Axx-11x K?
U 1 1 61336BBA
P 5350 1350
F 0 "K?" H 5680 1350 50  0001 L CNN
F 1 "DIPxx-1Axx-11x" H 5680 1305 50  0001 L CNN
F 2 "Relay_THT:Relay_StandexMeder_DIP_LowProfile" H 5700 1300 50  0001 L CNN
F 3 "https://standexelectronics.com/wp-content/uploads/datasheet_reed_relay_DIP.pdf" H 5350 1350 50  0001 C CNN
	1    5350 1350
	1    0    0    -1  
$EndComp
$Comp
L Device:Q_NPN_BCE Q?
U 1 1 6133823D
P 5050 1950
F 0 "Q?" H 5241 1950 50  0001 L CNN
F 1 "Q_NPN_BCE" H 5241 1905 50  0001 L CNN
F 2 "" H 5250 2050 50  0001 C CNN
F 3 "~" H 5050 1950 50  0001 C CNN
	1    5050 1950
	1    0    0    -1  
$EndComp
$Comp
L power:+5V #PWR?
U 1 1 6133DF0D
P 5150 900
F 0 "#PWR?" H 5150 750 50  0001 C CNN
F 1 "+5V" H 5165 1073 50  0000 C CNN
F 2 "" H 5150 900 50  0001 C CNN
F 3 "" H 5150 900 50  0001 C CNN
	1    5150 900 
	1    0    0    -1  
$EndComp
$Comp
L Device:R R1
U 1 1 6133E610
P 4700 1950
F 0 "R1" V 4493 1950 50  0000 C CNN
F 1 "10k" V 4584 1950 50  0000 C CNN
F 2 "" V 4630 1950 50  0001 C CNN
F 3 "~" H 4700 1950 50  0001 C CNN
	1    4700 1950
	0    1    1    0   
$EndComp
$Comp
L power:GND #PWR?
U 1 1 6133F266
P 5150 2150
F 0 "#PWR?" H 5150 1900 50  0001 C CNN
F 1 "GND" H 5155 1977 50  0000 C CNN
F 2 "" H 5150 2150 50  0001 C CNN
F 3 "" H 5150 2150 50  0001 C CNN
	1    5150 2150
	1    0    0    -1  
$EndComp
$Comp
L Device:D D1
U 1 1 6134005E
P 4800 1350
F 0 "D1" V 4800 1150 50  0000 L CNN
F 1 "D" V 4850 1150 50  0001 L CNN
F 2 "" H 4800 1350 50  0001 C CNN
F 3 "~" H 4800 1350 50  0001 C CNN
	1    4800 1350
	0    1    1    0   
$EndComp
Wire Wire Line
	4800 1200 4800 1050
Wire Wire Line
	5150 1650 5150 1750
Wire Wire Line
	4800 1500 4800 1650
Wire Wire Line
	4800 1650 5150 1650
Connection ~ 5150 1650
Wire Wire Line
	5150 1050 4800 1050
Connection ~ 5150 1050
Wire Wire Line
	5150 900  5150 1050
Text Notes 4750 650  0    50   ~ 0
Dioda zabezpieczająca elementy indukcyjne
$EndSCHEMATC
