create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id) on delete cascade
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id) on delete cascade,
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id) on delete cascade
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id) on delete cascade,
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id) on delete cascade,
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id) on delete cascade,
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id) on delete cascade,
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id) on delete cascade
);

create sequence GlobalSequencer nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    constraint FSrvrCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvrSrvc number,
    SrvrSrvcCls number,
    constraint FSrvrSrvc foreign key (SrvrSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create table EnkfsMngr(
    id number primary key,
    Cls number not null,
    constraint FEnkfsMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    EnkfsMngrThis number,
    EnkfsMngrThisCls number,
    constraint FEnkfsMngrThis foreign key (EnkfsMngrThisCls) references Cls (id)    
);

create table Bstllng(
    id number primary key,
    Cls number not null,
    constraint FBstllngCls foreign key (Cls) references Cls (id) on delete cascade,
    BstllngID varchar2(2000),
    BstllngBstllstts number,
    BstllngBstllsttsCls number,
    constraint FBstllngBstllstts foreign key (BstllngBstllsttsCls) references Cls (id),
    BstllngThis number,
    BstllngThisCls number,
    constraint FBstllngThis foreign key (BstllngThisCls) references Cls (id)    
);

create table Lfrrt(
    id number primary key,
    Cls number not null,
    constraint FLfrrtCls foreign key (Cls) references Cls (id) on delete cascade,
    LfrrtNm varchar2(2000),
    LfrrtLfrzt number,
    LfrrtPrs varchar2(2000),
    LfrrtThis number,
    LfrrtThisCls number,
    constraint FLfrrtThis foreign key (LfrrtThisCls) references Cls (id)    
);
create index INmLfrrt on Lfrrt (LfrrtNm);


create table RgstrCMD(
    id number primary key,
    Cls number not null,
    constraint FRgstrCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    RgstrCMDUsrnm varchar2(2000),
    RgstrCMDPsswrt varchar2(2000),
    RgstrCMDInvoker number,
    RgstrCMDInvokerCls number,
    constraint FRgstrCMDInvoker foreign key (RgstrCMDInvokerCls) references Cls (id),
    RgstrCMDCReceiver number,
    RgstrCMDCReceiverCls number,
    constraint FRgstrCMDCReceiver foreign key (RgstrCMDCReceiverCls) references Cls (id),
    RgstrCMDMyCmmnDt number,
    RgstrCMDMyCmmnDtCls number,
    constraint FRgstrCMDMyCmmnDt foreign key (RgstrCMDMyCmmnDtCls) references Cls (id)    
);

create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table Bstllstts(
    id number primary key,
    Cls number not null,
    constraint FBstllsttsCls foreign key (Cls) references Cls (id) on delete cascade,
    BstllsttsThis number,
    BstllsttsThisCls number,
    constraint FBstllsttsThis foreign key (BstllsttsThisCls) references Cls (id)    
);

create table Artkl(
    id number primary key,
    Cls number not null,
    constraint FArtklCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtklArtklnmmr varchar2(2000),
    ArtklBzchnng varchar2(2000),
    ArtklPrs varchar2(2000),
    ArtklMnLgrbstnd number,
    ArtklMxLgrbstnd number,
    ArtklHstLfrzt number,
    ArtklThis number,
    ArtklThisCls number,
    constraint FArtklThis foreign key (ArtklThisCls) references Cls (id)    
);
create index IArtklnmmrArtkl on Artkl (ArtklArtklnmmr);
create index IBzchnngArtkl on Artkl (ArtklBzchnng);


create table Pstn(
    id number primary key,
    Cls number not null,
    constraint FPstnCls foreign key (Cls) references Cls (id) on delete cascade,
    PstnArtkl number,
    PstnArtklCls number,
    constraint FPstnArtkl foreign key (PstnArtklCls) references Cls (id),
    PstnMng number,
    PstnThis number,
    PstnThisCls number,
    constraint FPstnThis foreign key (PstnThisCls) references Cls (id)    
);

create table Srvc(
    id number primary key,
    Cls number not null,
    constraint FSrvcCls foreign key (Cls) references Cls (id) on delete cascade,
    SrvcThis number,
    SrvcThisCls number,
    constraint FSrvcThis foreign key (SrvcThisCls) references Cls (id),
    SrvcKndEnkfsMngr number,
    SrvcKndEnkfsMngrCls number,
    constraint FSrvcKndEnkfsMngr foreign key (SrvcKndEnkfsMngrCls) references Cls (id),
    SrvcAdmnWrnlgr number,
    SrvcAdmnWrnlgrCls number,
    constraint FSrvcAdmnWrnlgr foreign key (SrvcAdmnWrnlgrCls) references Cls (id),
    SrvcAdmnArtklMngr number,
    SrvcAdmnArtklMngrCls number,
    constraint FSrvcAdmnArtklMngr foreign key (SrvcAdmnArtklMngrCls) references Cls (id),
    SrvcAdmnLfrrtMngr number,
    SrvcAdmnLfrrtMngrCls number,
    constraint FSrvcAdmnLfrrtMngr foreign key (SrvcAdmnLfrrtMngrCls) references Cls (id)    
);
create index IEnkfsMngrSrvcKnd on Srvc (SrvcKndEnkfsMngr, SrvcKndEnkfsMngrCls);
create index IWrnlgrSrvcAdmn on Srvc (SrvcAdmnWrnlgr, SrvcAdmnWrnlgrCls);
create index IArtklMngrSrvcAdmn on Srvc (SrvcAdmnArtklMngr, SrvcAdmnArtklMngrCls);
create index ILfrrtMngrSrvcAdmn on Srvc (SrvcAdmnLfrrtMngr, SrvcAdmnLfrrtMngrCls);


create table ArtklMngr(
    id number primary key,
    Cls number not null,
    constraint FArtklMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtklMngrThis number,
    ArtklMngrThisCls number,
    constraint FArtklMngrThis foreign key (ArtklMngrThisCls) references Cls (id)    
);

create table Knt(
    id number primary key,
    Cls number not null,
    constraint FKntCls foreign key (Cls) references Cls (id) on delete cascade,
    KntKntstnd varchar2(2000),
    KntLmt varchar2(2000),
    KntThis number,
    KntThisCls number,
    constraint FKntThis foreign key (KntThisCls) references Cls (id)    
);

create table Knd(
    id number primary key,
    Cls number not null,
    constraint FKndCls foreign key (Cls) references Cls (id) on delete cascade,
    KndBntzrnm varchar2(2000),
    KndPsswrt varchar2(2000),
    KndKnt number,
    KndKntCls number,
    constraint FKndKnt foreign key (KndKntCls) references Cls (id),
    KndThis number,
    KndThisCls number,
    constraint FKndThis foreign key (KndThisCls) references Cls (id)    
);
create index IBntzrnmKnd on Knd (KndBntzrnm);


create table LfrrtMngr(
    id number primary key,
    Cls number not null,
    constraint FLfrrtMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    LfrrtMngrThis number,
    LfrrtMngrThisCls number,
    constraint FLfrrtMngrThis foreign key (LfrrtMngrThisCls) references Cls (id)    
);

create table Lfrng(
    id number primary key,
    Cls number not null,
    constraint FLfrngCls foreign key (Cls) references Cls (id) on delete cascade,
    LfrngBstllng number,
    LfrngBstllngCls number,
    constraint FLfrngBstllng foreign key (LfrngBstllngCls) references Cls (id),
    LfrngLfrrt number,
    LfrngLfrrtCls number,
    constraint FLfrngLfrrt foreign key (LfrngLfrrtCls) references Cls (id),
    LfrngLfrvrsch number,
    LfrngThis number,
    LfrngThisCls number,
    constraint FLfrngThis foreign key (LfrngThisCls) references Cls (id)    
);

create table Wrnlgr(
    id number primary key,
    Cls number not null,
    constraint FWrnlgrCls foreign key (Cls) references Cls (id) on delete cascade,
    WrnlgrThis number,
    WrnlgrThisCls number,
    constraint FWrnlgrThis foreign key (WrnlgrThisCls) references Cls (id)    
);

create table CmmnDt(
    id number primary key,
    Cls number not null,
    constraint FCmmnDtCls foreign key (Cls) references Cls (id) on delete cascade,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create table Artklstts(
    id number primary key,
    Cls number not null,
    constraint FArtklsttsCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtklsttsThis number,
    ArtklsttsThisCls number,
    constraint FArtklsttsThis foreign key (ArtklsttsThisCls) references Cls (id)    
);

create table CmmndExctr(
    id number primary key,
    Cls number not null,
    constraint FCmmndExctrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table EnkfsMngrEnkfsLst(
    id number primary key,
    frm number not null,
    enkfsLst number not null,
    Cls number not null,
    constraint FEnkfsMngrEnkfsLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FEnkfsMngrEnkfsLstfrm foreign key(frm) references EnkfsMngr(id)
);
create index IFrmEnkfsMngrEnkfsLst on EnkfsMngrEnkfsLst(frm);

create table BstllngPstnsLst(
    id number primary key,
    frm number not null,
    pstnsLst number not null,
    Cls number not null,
    constraint FBstllngPstnsLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FBstllngPstnsLstfrm foreign key(frm) references Bstllng(id)
);
create index IFrmBstllngPstnsLst on BstllngPstnsLst(frm);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create table ArtklMngrArtklLst(
    id number primary key,
    frm number not null,
    artklLst number not null,
    Cls number not null,
    constraint FArtklMngrArtklLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FArtklMngrArtklLstfrm foreign key(frm) references ArtklMngr(id)
);
create index IFrmArtklMngrArtklLst on ArtklMngrArtklLst(frm);

create table LfrrtMngrLfrrtnLst(
    id number primary key,
    frm number not null,
    lfrrtnLst number not null,
    Cls number not null,
    constraint FLfrrtMngrLfrrtnLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FLfrrtMngrLfrrtnLstfrm foreign key(frm) references LfrrtMngr(id)
);
create index IFrmLfrrtMngrLfrrtnLst on LfrrtMngrLfrrtnLst(frm);

create table WrnlgrWrnLst(
    id number primary key,
    frm number not null,
    wrnLst number not null,
    Cls number not null,
    constraint FWrnlgrWrnLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FWrnlgrWrnLstfrm foreign key(frm) references Wrnlgr(id)
);
create index IFrmWrnlgrWrnLst on WrnlgrWrnLst(frm);

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);
