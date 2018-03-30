SET NAMES 'utf8';

INSERT INTO ps_konfiguracija VALUES (1, 'Putanja', 'c:\\tmp\\', 'Koren stabla za smestanje dokumentacije');

INSERT INTO ps_status VALUES
(1, 'У току', 'Статус након уноса'),
(2, 'Послат на проверу', 'Предмер послат на проверу у финансије'),
(3, 'Одобрен', 'Нема дуговања, може да иде'),
(4, 'Уложен приговор', 'Има дуговања, не може да иде'),
(5, 'Комплетиран', 'Предмет је завршен, купац је обавештен'),
(6, 'Сторниран', 'Предмет је сторниран');

INSERT INTO ps_status_grupe_zahteva VALUES
(1, 'Креиран', NULL),
(2, 'У току', NULL),
(3, 'Комплетиран', NULL);

INSERT INTO ps_tehnicki_centar VALUES
(1, 'Београд', 'Масарикова 2'),
(2, 'Нови Сад', 'Булевар Особођења 229'),
(3, 'Краљево', 'Цара Душана 15'),
(4, 'Крагујевац', 'Карађорђева 10'),
(5, 'Ниш', 'Адреса бб');

INSERT INTO ps_tip_dokumenta VALUES
(1, 'ПС01', '1'),
(2, 'ПС02', '2'),
(3, 'Доказ', 'д'),
(4, 'Остало', 'о');

INSERT INTO ps_grupa_zahteva VALUES
(2, 'Јануар', '2018', 2),
(3, 'Фебруар', '2018', 2),
(4, 'Март', '2018', 1),
(5, 'Април', '2018', 1),
(7, 'Мај', '2018', 1);

INSERT INTO ps_kupac VALUES
(1, 'Владимир Урошевић', '2810976760017', NULL, NULL, NULL, 'Ђуре Даничића 81/4 Смедерево', '(026) 461-0303', 'vladimir.urosevic@gmail.com', 'FL'),
(4, 'AD Luka Senta', NULL, '12121212', '1212121212', 'Пера Перић', 'Senta', '(011) 456-4458', 'luka@gmail.com', 'PL'),
(10, 'Пера Перић', '1234567899999', NULL, NULL, NULL, '4654', '(011) 655-8555', 'pera@peric.com', 'FL'),
(13, 'тест', NULL, '21321312', '1312321312', 'Миле Китић', 'тес', '(011) 222-2444', 'pea@prc.com', 'PL');

INSERT INTO ps_snabdevac VALUES
(1, '"HIDROELECTRICA TRADING" д.о.о., Београд-Стари Град', '21058050', 'Београд', 'Македонска 30'),
(2, 'Предузеће "С.О.К." ДОО, Краљево', '20354747', 'Краљевo', 'Мирка Луковића бр. 2'),
(3, 'Предузеће "CROSSOVER TEAM Д.О.О. БЕОГРАД", Београд', '21112925', 'Београд', 'Иванковачка бр. 6/ локал 6'),
(4, 'Предузеће "ROSE POWER" д.о.о., Београд-Савски венац', '21111147', 'Београд', 'Ресавска бр. 66'),
(5, 'Привредно друштво за производњу промет и услуге "НОЛЕКО ДОО", ЧАЧАК', '20848731', 'Чачак', 'Булевар ослободилаца бб'),
(6, '"ARMAND GROUP SRB" доо, Београд', '21128562', 'Београд, Нови Београд', 'Јурија Гагарина 231, локал 326'),
(7, 'Привредно друштво "SENTRADE RS" доо, Београд', '21086037', 'Београд, Нови Београд', 'Рашка Димитријевића 13/4'),
(8, 'Привредно друштво за трговину електричном енергијом "GRAND ENERGY DISTRIBUTION" доо, Пирот', '21090751', 'Пирот', 'Николе Тесле 7, локал 2'),
(9, 'Јавно предузеће "Електропривреда Србије" Београд', '20053658', 'Београд', 'Царице Милице бр. 2'),
(10, 'Привредно друштвo „ЕПЦГ“ д.о.о. Београд', '20491515', 'Београд', 'Балканска 13/II'),
(11, 'Привредно друштво за трговину електричном енергијом ENERGY MARKET доо, Пирот', '20762918', 'Пирот', 'Књаза Милоша 4/26'),
(12, 'AXPO друштво са ограниченом одговорношћу,Београд', '20189053', 'Београд, Нови Београд', 'Милутина Миланковића 11а'),
(13, 'EFT TRADE д.о.о., Београд', '20743662', 'Београд, Нови Београд', 'Шпанских бораца 3/IV'),
(14, 'Привредно друштво за трговину струјом „EQM“ д.о.о. Пирот', '20283092', 'Пирот', 'Српских владара 233'),
(15, '"ČEZ SRBIJA" DOO BEOGRAD', '20180650', 'Београд, Нови Београд', 'Булевар Зорана Ђинђића 65/I/ст.1'),
(16, '"HSE BALKAN ENERGY" д.о.о. Друштво за инжењеринг и трговину', '20119977', 'Београд, Нови Београд', 'Милутина Миланковића 27'),
(17, '“NOVA COMMODITIES“ друштво са ограниченом одговорношћу, Београд', '20936614', 'Београд', 'Вука Караџића бр. 9'),
(18, 'MISTEL ENERGY д.о.о. Београд-Звездара', '20967790', 'Београд', 'Булевар Краља Александра 270'),
(19, 'TINMAR ENERGY д.о.о., Београд', '20541369', 'Београд', 'Македонска 30'),
(20, 'ЕИ-предузеће за производњу и дистрибуцију енергетике и пружање услуга ЕЛМАГ доо, Ниш', '7211872', 'Ниш', 'Булавар цара Константина 80-82'),
(21, 'Привредно друштво "PROENERGYBGD" доо, Београд', '20894172', 'Београд, Нови Београд', 'Владимира Поповића 6'),
(22, '"Нафтна индустрија Србије"а.д. Нови Сад', '20084693', 'Нови Сад', 'Народног фронта број 12'),
(23, 'ELGAS ENERGY TRADING друштво са ограниченом одговорношћу, Београд', '20808098', 'Београд', 'Таковска 23-25'),
(24, 'Привредно друштво "NETWORK FOR TRADING" доо, Београд', '21005339', 'Београд, Нови Београд', 'Владимира Поповића 40, V спрат, стан 254'),
(25, 'Привредно друштво "ENG SERVICE TRADE" доо, Београд', '21030791', 'Београд, Земун', 'Карађорђев трг 40е'),
(26, 'GEN-I друштво са ограниченом одговорношћу Београд', '20193816', 'Београд, Нови Београд', 'Владимира Поповића 6'),
(27, 'Привредно друштво ПРОЕНТРА доо, Нови Београд', '20841290', 'Београд, Нови Београд', 'Булевар Арсенија Чарнојевића 70/8'),
(28, 'MVM PARTNER SERBIA д.о.о., Београд', '20700483', 'Београд, Нови Београд', 'Нехруова 132/13'),
(29, '"Budapest-Energy Trading SR" Београд', '20315075', 'Београд, Нови Београд', 'Владимира Поповића 50/464'),
(30, 'ENEL TRADE SERBIA доо, Београд', '20776943', 'Београд', 'Косанчићев венац 20'),
(31, 'Привредно друштво ЕНЕКОД доо, Ниш', '21164283', 'Ниш', 'Булевар Немањића 85а, ТПЦ Зона II, локал 36'),
(32, 'EVN Trading д.о.о. Београд', '20381892', 'Београд', 'Цинцар Јанкова број 3'),
(33, 'Привредно друштво "ENERGIA GAS AND POWER" д.о.о. Београд (Нови Београд)', '20948914', 'Београд, Нови Београд', 'Владимира Поповића 40/IV'),
(34, '"FUTURE ENERGY BGR" д.о.о., Нови Београд', '20986387', 'Београд, Нови Београд', 'Владимира Поповића 6-8'),
(35, 'АБ ЕНЕРГО доо, Београд', '21037893', 'Београд, Нови Београд', 'Булевар Михаила Пупина 10л'),
(36, 'MIS LOGISTIC доо, Параћин', '20399775', 'Параћин', 'Синђелићева 33'),
(37, 'DANSKE COMMODITIES SERBIA DOO BEOGRAD', '20698454', 'Београд, Нови Београд', 'Драгише Брашована 10/I'),
(38, 'GSA ENERGY доо, Београд', '20831693', 'Београд', 'Топличин венац 19-21'),
(39, 'Привредно друштво "LC ELECTRICITY SUPPLY AND TRADING" доо, Београд', '21032301', 'Београд, Нови Београд', 'Владимира Поповића 50/VI/463'),
(40, 'VERBUND Trading Serbia Beograd', '20279150', 'Београд, Нови Београд', 'Рашка Димитријевића 13/4'),
(41, '"ENEKO ENERGY" доо за производњу и трговину електричном енергијом, Каћ', '20700092', 'Каћ', 'Делфе Иванић 59'),
(42, 'ENERGY SUPPLY & TRADE доо, Београд - Савски венац', '20834404', 'Београд', 'Владете Ковачевића 2а'),
(43, 'ДРУШТВO ЗА ТРГОВИНУ HEP-TRADE ДОО БЕОГРАД', '20326000', 'Београд, Нови Београд', 'Милутина Миланковића 9ж/канц.119'),
(44, 'ПРВО ПЛИНАРСКО ДРУШТВО ДОО, Београд', '20957638', 'Београд, Нови Београд', 'Трешњиног Цвета 1'),
(45, '"AYEN ENERGY TRADING" доо, Београд', '21024708', 'Београд', 'Косанчићев венац 20'),
(46, 'PETROL Друштвo за трговину нафтом и нафтним дериватима д.о.о. Београд', '17454404', 'Београд', 'Патријарха Димитрија 12в'),
(47, 'Green Energy Trading д.о.о. Београд (Савски венац)', '20927127', 'Београд', 'Владете Ковачевића 2а'),
(48, 'Привредно друштво за произвидњу и трговину на велико ПЛАВА МУЊА д.о.о., Београд', '20643811', 'Београд', 'Обилићев венац 12'),
(49, '"RS ARIS ENERGO CONSULTING GROUP" доо, Београд', '21133582', 'Београд', '27. марта 39'),
(50, 'Предузеће "RAW AND REFINED COMMODITIES" д.о.о., Београд', '20572221', 'Београд', 'Тадеуша Кошћушка 30 спрат III, стан 8'),
(52, '"AVENTUS ENERGY" доо, Београд', '21175692', 'Београд', 'Цара Лазара 11/4'),
(53, '"MET SRB" д.о.о. Београд', '20952920', 'Београд, Нови Београд', 'Булевар Зорана Ђинђића 48а'),
(54, 'Предузеће "ENERGY DELIVERY SOLUTIONS" д.о.о., Београд', '21199150', 'Београд', 'Стојана Протића бр. 30'),
(55, '"ELECTRON TRADE 021" доо Ветерник предузеће за трговину електричном енергијом', '21016519', 'Нови Сад', 'Бранка Ћопића 11'),
(56, 'PRIVREDNO DRUŠTVO WEG KOLEKTOR DOO BEOGRAD', '20627913', 'Београд', 'Љутице Богдана 1а'),
(57, 'Јавно предузеће "Електропривреда Србије" Београд', '20053658', 'Београд', 'Царице Милице бр. 2'),
(59, 'НАВОН друштво са ограниченом одговорношћу, Лучани', '21213748', 'Лучани', 'Водоводска бб'),
(60, 'Друштво са ограниченом одговорношћу ТЕ-ТО ПАНЧЕВО, Панчево', '21138410', 'Панчево', 'Спољностарчевачка 199'),
(61, 'Привредно друштво "ЕЛЕМ ТРЕЈД СР" д.о.о., Београд', '21246239', 'Београд', 'Булевар Деспота Стефана 12'),
(62, '„NAFTACHEM” ДOO за трговину и услуге Сремска Каменица', '8791546', 'Нови Сад, Сремска Каменица', 'Војводе Путника 79, спрат 2'),
(63, '"ХИДРОИСТЕЛ" ДОО КЛЕНИКЕ, БУЈАНОВАЦ', '20400650', 'Кленике, Бујановац', 'Српски православни манастир Св. Прохор Пчињског'),
(64, '"METHOD ENERGY DOO" Сремска Каменица', '21238228', 'Сремска Каменица', 'Сремска бр. 2А/3');

INSERT INTO ps_promena_snabdevaca VALUES
(1, 2, 4, '2018-01-01', NULL, NULL, '18.01-2316/1-18', '2018-02-01', '2019-02-01', 2, '45', 0, 2, '2017-12-25', 'OD', '2018-01-01'),
(3, 2, 1, '2018-01-01', '2018-01-03', NULL, '18.01-4505/1-18', '2018-01-01', NULL, 5, '45 дана', 1, 2, NULL, 'OD', '2018-01-01'),
(4, 22, 4, '2018-01-01', NULL, NULL, '18.01-121515/17', '2018-01-01', '2019-01-01', 6, '45 дана', 0, 3, NULL, 'OD', '2018-01-01'),
(5, 34, 10, '2018-01-02', '2018-01-02', NULL, '18.01-3521/1-18', '2018-02-01', NULL, 3, '60 дана', 1, 3, NULL, 'OD', '2018-01-02'),
(6, 22, 10, '2018-01-04', NULL, NULL, '18.01-4569/1-18', '2018-01-01', '2019-01-01', 1, '30 дана', 0, 2, NULL, 'OD', '2018-01-04'),
(7, 2, 10, '2018-01-16', NULL, NULL, '18.01-4566/1-18', '2018-01-16', '2019-01-16', 1, '35 дана', 0, 2, NULL, 'OD', '2018-01-16');

INSERT INTO ps_merno_mesto VALUES
(1, '16423456', 4, 5600.00, 50.00, 5550.00, 1, 'Пере Металца 412'),
(6, '45435334', 2, 432.00, 231.00, 536.00, 4, 'Kneza Milosa 19'),
(8, '333222111', 1, 321.00, 231.00, 132.00, 3, 'Аdresa 41'),
(9, '76125361', 5, 123.00, 21.00, 32.00, 6, 'Нека адреса бб'),
(10, '46546542', 2, 480.00, 250.00, 445.00, 6, 'Svetogorska 10');

INSERT INTO user VALUES
(2, 'fin', '$2a$11$6zxJUgvpHqeZrwjNIgmqPuLF0UTM0d/TjxWbPZBYztIazRMG2OXsq', 'Пера', 'Марковић'),
(3, 'admin', '$2a$11$6zxJUgvpHqeZrwjNIgmqPuLF0UTM0d/TjxWbPZBYztIazRMG2OXsq', 'Жика', 'Павловић'),
(4, 'koordinator', '$2a$11$6zxJUgvpHqeZrwjNIgmqPuLF0UTM0d/TjxWbPZBYztIazRMG2OXsq', 'Живадин', 'Јарић'),
(5, 'menadzer', '$2a$11$6zxJUgvpHqeZrwjNIgmqPuLF0UTM0d/TjxWbPZBYztIazRMG2OXsq', 'Чутура', 'Павле'),
(6, 'vlada', '$2a$11$6zxJUgvpHqeZrwjNIgmqPuLF0UTM0d/TjxWbPZBYztIazRMG2OXsq', 'Владимир', 'Урошевић');

INSERT INTO user_roles VALUES
(1, 6, 'ROLE_KOORDINATOR'),
(2, 2, 'ROLE_FIN'),
(3, 3, 'ROLE_ADMIN'),
(4, 5, 'ROLE_MANAGER');