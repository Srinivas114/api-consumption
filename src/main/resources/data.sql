INSERT INTO public.bus(
    id, created_at, updated_at, bus_number, bound)
    VALUES
    (1, now(), now(), '301',1),
    (2, now(), now(), '301A',1),
    (3, now(), now(), '301A',1),
    (4, now(), now(), '402',2),
    (5, now(), now(), '402B',2),
    (6, now(), now(), '402C',2);


INSERT INTO public.bus_route(
	id, created_at, updated_at, route_name, bus_number)
	VALUES
	(1, now(), now(), 'Route-MN', '301'),
	(2, now(), now(), 'Route-MN', '301A'),
	(3, now(), now(), 'Route-AB', '402'),
	(4, now(), now(), 'Route-ABC', '402B'),
	(5, now(), now(), 'Route-ABC', '402C');


INSERT INTO public.bus_stop(
	id, created_at, updated_at,  stop_code, stop_name, bus_route_id, route_order)
	VALUES
	(1, now(), now(), 'LGPY', 'Lingam Pally', 1,    1),
	(2, now(), now(), 'GHBL', 'Gachibowli', 1,      2),
	(3, now(), now(), 'BIPK', 'Bio Park', 1,        3),
	(4, now(), now(), 'TLKI', 'Tolichoki', 1,       4),

	(5, now(), now(), 'LGPY', 'Lingam Pally', 2,    1),
    (6, now(), now(), 'GHBL', 'Gachibowli', 2,      2),
    (7, now(), now(), 'BIPK', 'Bio Park', 2,        3),
    (8, now(), now(), 'TLKI', 'Tolichoki', 2,       4),
    (9, now(), now(), 'MDPM', 'Mahedipatnam', 2,    5);

INSERT INTO public.bus_timing( id, created_at, updated_at, bus_id, bus_stop_id, bus_time, direction)
	VALUES
	(1,now(),now(),1,1,'9:00:00 UTC',1),
	(2,now(),now(),1,2,'9:20:00 UTC',1),
	(3,now(),now(),1,3,'9:30:00 UTC',1),
	(4,now(),now(),1,4,'10:00:00 UTC',1),

    (5,now(),now(),1,4,'10:30:00 UTC',2),
	(6,now(),now(),1,3,'11:00:00 UTC',2),
	(7,now(),now(),1,2,'11:10:00 UTC',2),
	(8,now(),now(),1,1,'11:30:00 UTC',2),

	(9,now(),now(),2,5,'10:00:00 UTC',1),
    (10,now(),now(),2,6,'10:20:00 UTC',1),
    (11,now(),now(),2,7,'10:30:00 UTC',1),
    (12,now(),now(),2,8,'11:00:00 UTC',1),
    (13,now(),now(),2,9,'11:30:00 UTC',1)
    ;