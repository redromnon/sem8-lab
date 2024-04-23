import time, datetime

#Initialize/Request clocks
master = datetime.datetime.today()
master = master.timestamp()
slave1 = master-10
slave2 = master+10
slave3 = master+20

print("Master Timestamp: ", datetime.datetime.fromtimestamp(master))
print("Slave 1 Timestamp: ", datetime.datetime.fromtimestamp(slave1))
print("Slave 2 Timestamp: ", datetime.datetime.fromtimestamp(slave2))
print("Slave 3 Timestamp: ", datetime.datetime.fromtimestamp(slave3))

#Calc difference
master_diff = master - master
slave1_diff = master - slave1
slave2_diff = master - slave2
slave3_diff = master - slave3

#Calculate avg
avg_diff = (master_diff + slave1_diff + slave2_diff + slave3_diff)/4
print("Average time difference: ", avg_diff)

#Send/Update Clocks
master = datetime.datetime.today()
master = master.timestamp() + avg_diff
master_final = master
slave1_final = master
slave2_final = master
slave3_final = master

print("Final Master Timestamp: ", datetime.datetime.fromtimestamp(master_final))
print("Final Slave 1 Timestamp: ", datetime.datetime.fromtimestamp(slave1_final))
print("Final Slave 2 Timestamp: ", datetime.datetime.fromtimestamp(slave2_final))
print("Final Slave 3 Timestamp: ", datetime.datetime.fromtimestamp(slave3_final))
