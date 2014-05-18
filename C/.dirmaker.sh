#!/bin/bash
for count in $(seq -f "%03g" 1 999)
do
    mkdir "p$count"
done
