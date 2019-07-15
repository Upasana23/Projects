import convertdictionaryvalues as cdv
import adddistancetoschedule as ads
import calcorderdeliverytime as cod
import npscalc as nc
import datetime as dt



delivery = {}
with open("/Users/upasanapattnaik/Desktop/DroneDelivery/file.txt", "r") as filestream:
    with open("output.txt", "w") as filestreamtwo:
        for line in filestream:
            k, v = line.split(" ", 1)
            delivery[k.strip()] = v.strip()

        delivery_schedule = cdv.convert_input(delivery)
        #sort by order time
        delivery_schedule = ads.delivery_distance(delivery_schedule)
        drone_start_time = dt.time(6, 0, 0)
        drone_end_time = dt.time(22, 0, 0)
        delivered_order_schedule = cod.delivery_order(delivery_schedule, drone_start_time, drone_end_time)
        nps_value = nc.nps(delivered_order_schedule, 0, 0)  # promotor count pcount = 0, detractor count dcount = 0

        for key in delivered_order_schedule:
            dtime = delivered_order_schedule[key][5]
            dtime = dtime.strftime("%H:%M:%S")
            filestreamtwo.write(str(key) + " " + dtime)
            filestreamtwo.write("\n")

        filestreamtwo.write("NPS ")
        filestreamtwo.write(str(nps_value))
        filestreamtwo.close()

filestream.close()