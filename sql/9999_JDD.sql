insert into tob_dev.tobuser values (11,'Toteuch','1234');
insert into tob_dev.gamesystem(gamesystem_id, galaxy, system) values(1,1,1);
insert into tob_dev.gamesystem(gamesystem_id, galaxy, system) values(2,1,2);
insert into tob_dev.gamesystem(gamesystem_id, galaxy, system) values(3,1,3);
insert into tob_dev.gamesystem(gamesystem_id, galaxy, system) values(4,1,4);
insert into tob_dev.jobsurveillance(jobsurveillance_id, target, tobuser_id, starttime, endtime, isactive, waitbetweenss) 
	values (1, 'toto', 11, date '2000-01-01' + Interval '22:00', date '2000-01-02' + Interval '05:00', true, 7);
insert into tob_dev.jobsurveillance_gamesystem values (1, 1);
insert into tob_dev.jobsurveillance_gamesystem values (1, 2);
insert into tob_dev.jobsurveillance_gamesystem values (1, 3);
insert into tob_dev.jobsurveillance_gamesystem values (1, 4);
commit;