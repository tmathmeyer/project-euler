#!/bin/bash

read -p "enter a problem number (leading 0s please)  " num
mkdir $num
cp .template.c $num/solution.c
