export interface ITarea {
    identificador   : number;
    descripcion     : string;
    fechaCreacion   : Date;
    vigente         : boolean;
    type?           : string;
}

export interface IMap {
    key             : string;   
    value           : string;
}
