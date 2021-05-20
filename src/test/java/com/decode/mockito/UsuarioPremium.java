package com.decode.mockito;




public  class UsuarioPremium implements IUsuarioTest{
	 private IAlmacen aUsuarioPremium;
	

	public UsuarioPremium(IAlmacen usuarioPremiumAlmacen) {
		aUsuarioPremium =  usuarioPremiumAlmacen;
		
	}

	@Override
	public boolean makeUsuarioPremium(Portion portion) throws NotEnoughException {

		boolean isEnoughUsuarioPremium = aUsuarioPremium.getPortion(portion);
		

		if (isEnoughUsuarioPremium) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public IAlmacen getUsuarioPremiumAlmacen() {
		return aUsuarioPremium;
	}




	
	

	

	

}
