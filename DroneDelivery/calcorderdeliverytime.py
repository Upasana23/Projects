import datetime as dt
import prioritycalculator as pc
"""
Calculating the schedule time and delivers orders

"""

def delivery_order(delivery_schedule, start, end):
    priority = pc.calc_priority(delivery_schedule)
    next_time = start
    end_time = end

    if next_time <= end_time:
        for key in priority:
            # start time till be the order placement time if the start time is less than the order placement time
            if next_time < delivery_schedule[key][2]:
                start_time = delivery_schedule[key][2]
            else:
                start_time = next_time

            delivery_time = (dt.datetime.combine(dt.date(1, 1, 1), start_time) + dt.timedelta(
                    minutes=delivery_schedule[key][4])).time()
                # print("Delivery Time", delivery_time)
            delivery_schedule[key].append(delivery_time)

            next_time = (dt.datetime.combine(dt.date(1, 1, 1), start_time) + dt.timedelta(
                    minutes=2 * delivery_schedule[key][4])).time()

    return delivery_schedule