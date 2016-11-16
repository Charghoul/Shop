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


create table ArtEntnCMD(
    id number primary key,
    Cls number not null,
    constraint FArtEntnCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtEntnCMDPstn number,
    ArtEntnCMDPstnCls number,
    constraint FArtEntnCMDPstn foreign key (ArtEntnCMDPstnCls) references Cls (id),
    ArtEntnCMDInvoker number,
    ArtEntnCMDInvokerCls number,
    constraint FArtEntnCMDInvoker foreign key (ArtEntnCMDInvokerCls) references Cls (id),
    ArtEntnCMDCReceiver number,
    ArtEntnCMDCReceiverCls number,
    constraint FArtEntnCMDCReceiver foreign key (ArtEntnCMDCReceiverCls) references Cls (id),
    ArtEntnCMDMyCmmnDt number,
    ArtEntnCMDMyCmmnDtCls number,
    constraint FArtEntnCMDMyCmmnDt foreign key (ArtEntnCMDMyCmmnDtCls) references Cls (id)    
);

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
    BstllngBstllID varchar2(2000),
    BstllngBstllstts number,
    BstllngBstllsttsCls number,
    constraint FBstllngBstllstts foreign key (BstllngBstllsttsCls) references Cls (id),
    BstllngThis number,
    BstllngThisCls number,
    constraint FBstllngThis foreign key (BstllngThisCls) references Cls (id)    
);
create index IBstllIDBstllng on Bstllng (BstllngBstllID);


create table ArtEntfCMD(
    id number primary key,
    Cls number not null,
    constraint FArtEntfCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtEntfCMDPstn number,
    ArtEntfCMDPstnCls number,
    constraint FArtEntfCMDPstn foreign key (ArtEntfCMDPstnCls) references Cls (id),
    ArtEntfCMDMng number,
    ArtEntfCMDInvoker number,
    ArtEntfCMDInvokerCls number,
    constraint FArtEntfCMDInvoker foreign key (ArtEntfCMDInvokerCls) references Cls (id),
    ArtEntfCMDCReceiver number,
    ArtEntfCMDCReceiverCls number,
    constraint FArtEntfCMDCReceiver foreign key (ArtEntfCMDCReceiverCls) references Cls (id),
    ArtEntfCMDMyCmmnDt number,
    ArtEntfCMDMyCmmnDtCls number,
    constraint FArtEntfCMDMyCmmnDt foreign key (ArtEntfCMDMyCmmnDtCls) references Cls (id)    
);

create table HrstllrMngr(
    id number primary key,
    Cls number not null,
    constraint FHrstllrMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    HrstllrMngrThis number,
    HrstllrMngrThisCls number,
    constraint FHrstllrMngrThis foreign key (HrstllrMngrThisCls) references Cls (id)    
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

create table AndrArtklCMD(
    id number primary key,
    Cls number not null,
    constraint FAndrArtklCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    AndrArtklCMDArtkl number,
    AndrArtklCMDArtklCls number,
    constraint FAndrArtklCMDArtkl foreign key (AndrArtklCMDArtklCls) references Cls (id),
    AndrArtklCMDBzchnng varchar2(2000),
    AndrArtklCMDPrs varchar2(2000),
    AndrArtklCMDMnLgrbstnd number,
    AndrArtklCMDMxLgrbstnd number,
    AndrArtklCMDHstLfrzt number,
    AndrArtklCMDInvoker number,
    AndrArtklCMDInvokerCls number,
    constraint FAndrArtklCMDInvoker foreign key (AndrArtklCMDInvokerCls) references Cls (id),
    AndrArtklCMDCReceiver number,
    AndrArtklCMDCReceiverCls number,
    constraint FAndrArtklCMDCReceiver foreign key (AndrArtklCMDCReceiverCls) references Cls (id),
    AndrArtklCMDMyCmmnDt number,
    AndrArtklCMDMyCmmnDtCls number,
    constraint FAndrArtklCMDMyCmmnDt foreign key (AndrArtklCMDMyCmmnDtCls) references Cls (id)    
);

create table Kmpnnt(
    id number primary key,
    Cls number not null,
    constraint FKmpnntCls foreign key (Cls) references Cls (id) on delete cascade,
    KmpnntThis number,
    KmpnntThisCls number,
    constraint FKmpnntThis foreign key (KmpnntThisCls) references Cls (id),
    ArtklArtklnmmr varchar2(2000),
    ArtklBzchnng varchar2(2000),
    ArtklPrs varchar2(2000),
    ArtklMnLgrbstnd number,
    ArtklMxLgrbstnd number,
    ArtklHstLfrzt number,
    ArtklArtklstts number,
    ArtklArtklsttsCls number,
    constraint FArtklArtklstts foreign key (ArtklArtklsttsCls) references Cls (id),
    ArtklHrstllr number,
    ArtklHrstllrCls number,
    constraint FArtklHrstllr foreign key (ArtklHrstllrCls) references Cls (id),
    PrdktgrppNm varchar2(2000)    
);
create index IArtklnmmrArtkl on Kmpnnt (ArtklArtklnmmr);
create index IBzchnngArtkl on Kmpnnt (ArtklBzchnng);
create index INmPrdktgrpp on Kmpnnt (PrdktgrppNm);


create table CmmndCrdntr(
    id number primary key,
    Cls number not null,
    constraint FCmmndCrdntrCls foreign key (Cls) references Cls (id) on delete cascade    
);

create table ArtklEnlgrnCMD(
    id number primary key,
    Cls number not null,
    constraint FArtklEnlgrnCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtklEnlgrnCMDArtkl number,
    ArtklEnlgrnCMDArtklCls number,
    constraint FArtklEnlgrnCMDArtkl foreign key (ArtklEnlgrnCMDArtklCls) references Cls (id),
    ArtklEnlgrnCMDMng number,
    ArtklEnlgrnCMDInvoker number,
    ArtklEnlgrnCMDInvokerCls number,
    constraint FArtklEnlgrnCMDInvoker foreign key (ArtklEnlgrnCMDInvokerCls) references Cls (id),
    ArtklEnlgrnCMDCReceiver number,
    ArtklEnlgrnCMDCReceiverCls number,
    constraint FArtklEnlgrnCMDCReceiver foreign key (ArtklEnlgrnCMDCReceiverCls) references Cls (id),
    ArtklEnlgrnCMDMyCmmnDt number,
    ArtklEnlgrnCMDMyCmmnDtCls number,
    constraint FArtklEnlgrnCMDMyCmmnDt foreign key (ArtklEnlgrnCMDMyCmmnDtCls) references Cls (id)    
);

create table Bstllstts(
    id number primary key,
    Cls number not null,
    constraint FBstllsttsCls foreign key (Cls) references Cls (id) on delete cascade,
    BstllsttsThis number,
    BstllsttsThisCls number,
    constraint FBstllsttsThis foreign key (BstllsttsThisCls) references Cls (id)    
);

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
    SrvcKndArtklMngr number,
    SrvcKndArtklMngrCls number,
    constraint FSrvcKndArtklMngr foreign key (SrvcKndArtklMngrCls) references Cls (id),
    SrvcAdmnWrnlgr number,
    SrvcAdmnWrnlgrCls number,
    constraint FSrvcAdmnWrnlgr foreign key (SrvcAdmnWrnlgrCls) references Cls (id),
    SrvcAdmnArtklMngr number,
    SrvcAdmnArtklMngrCls number,
    constraint FSrvcAdmnArtklMngr foreign key (SrvcAdmnArtklMngrCls) references Cls (id),
    SrvcAdmnLfrrtMngr number,
    SrvcAdmnLfrrtMngrCls number,
    constraint FSrvcAdmnLfrrtMngr foreign key (SrvcAdmnLfrrtMngrCls) references Cls (id),
    SrvcAdmnHrstllrMngr number,
    SrvcAdmnHrstllrMngrCls number,
    constraint FSrvcAdmnHrstllrMngr foreign key (SrvcAdmnHrstllrMngrCls) references Cls (id)    
);
create index IEnkfsMngrSrvcKnd on Srvc (SrvcKndEnkfsMngr, SrvcKndEnkfsMngrCls);
create index ILfrrtMngrSrvcAdmn on Srvc (SrvcAdmnLfrrtMngr, SrvcAdmnLfrrtMngrCls);
create index IHrstllrMngrSrvcAdmn on Srvc (SrvcAdmnHrstllrMngr, SrvcAdmnHrstllrMngrCls);


create table ArtklMngr(
    id number primary key,
    Cls number not null,
    constraint FArtklMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    ArtklMngrThis number,
    ArtklMngrThisCls number,
    constraint FArtklMngrThis foreign key (ArtklMngrThisCls) references Cls (id)    
);

create table SttsAslfCMD(
    id number primary key,
    Cls number not null,
    constraint FSttsAslfCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    SttsAslfCMDInvoker number,
    SttsAslfCMDInvokerCls number,
    constraint FSttsAslfCMDInvoker foreign key (SttsAslfCMDInvokerCls) references Cls (id),
    SttsAslfCMDCReceiver number,
    SttsAslfCMDCReceiverCls number,
    constraint FSttsAslfCMDCReceiver foreign key (SttsAslfCMDCReceiverCls) references Cls (id),
    SttsAslfCMDMyCmmnDt number,
    SttsAslfCMDMyCmmnDtCls number,
    constraint FSttsAslfCMDMyCmmnDt foreign key (SttsAslfCMDMyCmmnDtCls) references Cls (id)    
);

create table NrArtklCMD(
    id number primary key,
    Cls number not null,
    constraint FNrArtklCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    NrArtklCMDArtklnmmr varchar2(2000),
    NrArtklCMDBzchnng varchar2(2000),
    NrArtklCMDPrs varchar2(2000),
    NrArtklCMDMnLgrbstnd number,
    NrArtklCMDMxLgrbstnd number,
    NrArtklCMDHstLfrzt number,
    NrArtklCMDInvoker number,
    NrArtklCMDInvokerCls number,
    constraint FNrArtklCMDInvoker foreign key (NrArtklCMDInvokerCls) references Cls (id),
    NrArtklCMDCReceiver number,
    NrArtklCMDCReceiverCls number,
    constraint FNrArtklCMDCReceiver foreign key (NrArtklCMDCReceiverCls) references Cls (id),
    NrArtklCMDMyCmmnDt number,
    NrArtklCMDMyCmmnDtCls number,
    constraint FNrArtklCMDMyCmmnDt foreign key (NrArtklCMDMyCmmnDtCls) references Cls (id)    
);

create table SttsVrkfCMD(
    id number primary key,
    Cls number not null,
    constraint FSttsVrkfCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    SttsVrkfCMDInvoker number,
    SttsVrkfCMDInvokerCls number,
    constraint FSttsVrkfCMDInvoker foreign key (SttsVrkfCMDInvokerCls) references Cls (id),
    SttsVrkfCMDCReceiver number,
    SttsVrkfCMDCReceiverCls number,
    constraint FSttsVrkfCMDCReceiver foreign key (SttsVrkfCMDCReceiverCls) references Cls (id),
    SttsVrkfCMDMyCmmnDt number,
    SttsVrkfCMDMyCmmnDtCls number,
    constraint FSttsVrkfCMDMyCmmnDt foreign key (SttsVrkfCMDMyCmmnDtCls) references Cls (id)    
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


create table Hrstllr(
    id number primary key,
    Cls number not null,
    constraint FHrstllrCls foreign key (Cls) references Cls (id) on delete cascade,
    HrstllrNm varchar2(2000),
    HrstllrThis number,
    HrstllrThisCls number,
    constraint FHrstllrThis foreign key (HrstllrThisCls) references Cls (id)    
);
create index INmHrstllr on Hrstllr (HrstllrNm);


create table LfrrtMngr(
    id number primary key,
    Cls number not null,
    constraint FLfrrtMngrCls foreign key (Cls) references Cls (id) on delete cascade,
    LfrrtMngrThis number,
    LfrrtMngrThisCls number,
    constraint FLfrrtMngrThis foreign key (LfrrtMngrThisCls) references Cls (id)    
);

create table PrdGEntfrnnCMD(
    id number primary key,
    Cls number not null,
    constraint FPrdGEntfrnnCMDCls foreign key (Cls) references Cls (id) on delete cascade,
    PrdGEntfrnnCMDInvoker number,
    PrdGEntfrnnCMDInvokerCls number,
    constraint FPrdGEntfrnnCMDInvoker foreign key (PrdGEntfrnnCMDInvokerCls) references Cls (id),
    PrdGEntfrnnCMDCReceiver number,
    PrdGEntfrnnCMDCReceiverCls number,
    constraint FPrdGEntfrnnCMDCReceiver foreign key (PrdGEntfrnnCMDCReceiverCls) references Cls (id),
    PrdGEntfrnnCMDMyCmmnDt number,
    PrdGEntfrnnCMDMyCmmnDtCls number,
    constraint FPrdGEntfrnnCMDMyCmmnDt foreign key (PrdGEntfrnnCMDMyCmmnDtCls) references Cls (id)    
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

create table BlnX(
    id number primary key,
    Cls number not null,
    constraint FBlnXCls foreign key (Cls) references Cls (id) on delete cascade,
    BlnXThis number,
    BlnXThisCls number,
    constraint FBlnXThis foreign key (BlnXThisCls) references Cls (id)    
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

create table HrstllrMngrHrstllrLst(
    id number primary key,
    frm number not null,
    hrstllrLst number not null,
    Cls number not null,
    constraint FHrstllrMngrHrstllrLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FHrstllrMngrHrstllrLstfrm foreign key(frm) references HrstllrMngr(id)
);
create index IFrmHrstllrMngrHrstllrLst on HrstllrMngrHrstllrLst(frm);

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create table PrdktgrppKmpnntnLst(
    id number primary key,
    frm number not null,
    kmpnntnLst number not null,
    Cls number not null,
    constraint FPrdktgrppKmpnntnLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FPrdktgrppKmpnntnLstfrm foreign key(frm) references Kmpnnt(id)
);
create index IFrmPrdktgrppKmpnntnLst on PrdktgrppKmpnntnLst(frm);


create index IKmpnntnLstPrdktgrppKmpnntnLst on PrdktgrppKmpnntnLst(kmpnntnLst);
create table ArtklMngrArtklLst(
    id number primary key,
    frm number not null,
    artklLst number not null,
    Cls number not null,
    constraint FArtklMngrArtklLstCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FArtklMngrArtklLstfrm foreign key(frm) references ArtklMngr(id)
);
create index IFrmArtklMngrArtklLst on ArtklMngrArtklLst(frm);

create table ArtklMngrPrdktgrppn(
    id number primary key,
    frm number not null,
    prdktgrppn number not null,
    Cls number not null,
    constraint FArtklMngrPrdktgrppnCls foreign key(Cls) references Cls(id) on delete cascade,
    constraint FArtklMngrPrdktgrppnfrm foreign key(frm) references ArtklMngr(id)
);
create index IFrmArtklMngrPrdktgrppn on ArtklMngrPrdktgrppn(frm);

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

