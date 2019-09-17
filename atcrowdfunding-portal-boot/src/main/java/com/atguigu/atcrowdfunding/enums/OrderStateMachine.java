package com.atguigu.atcrowdfunding.enums;
public enum OrderStateMachine {
	
	/**
	 * 调度中
	 */
	DISPATCHING{
		@Override
		public OrderStateMachine nextState() {
			return DELIVERING;
		}

		@Override
		public OrderStateMachine prevState() {
			return this;
		}
	},
	
	/**
	 * 派送中
	 */
	DELIVERING{
		@Override
		public OrderStateMachine nextState() {
			return RECEIVED;
		}

		@Override
		public OrderStateMachine prevState() {
			return DISPATCHING;
		}
	},
	
	
	
	/**
	 * 已经收货
	 */
	RECEIVED{
		@Override
		public OrderStateMachine nextState() {
			return RECEIVED;
		}
		
		@Override
		public OrderStateMachine prevState() {
			return DELIVERING;
		}
	};
	
	
	
	/**
	 * 上一个状态
	 * @return
	 */
	public abstract OrderStateMachine nextState();
	/**
	 * 下一个状态
	 * @return
	 */
	public abstract OrderStateMachine prevState();

}
